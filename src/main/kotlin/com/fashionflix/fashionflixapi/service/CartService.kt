package com.fashionflix.fashionflixapi.service

import com.fashionflix.fashionflixapi.common.clients.db.cart.CartDTO
import com.fashionflix.fashionflixapi.common.clients.db.cart.CartRepository
import com.fashionflix.fashionflixapi.common.constants.generatedUniqueId
import com.fashionflix.fashionflixapi.exception.ProductException
import com.fashionflix.fashionflixapi.model.Cart
import com.fashionflix.fashionflixapi.model.CartItem
import com.fashionflix.fashionflixapi.model.Product
import com.fashionflix.fashionflixapi.model.User
import com.fashionflix.fashionflixapi.schema.AddItemRequest
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CartService(
    val cartRepository: CartRepository,
    val cartItemService: CartItemService,
    val userService: UserService,
    val productService: ProductService
) {

    fun createCart(userId: String): Cart? {
        val cart = CartDTO(
            generatedUniqueId(),
            userId,
            emptyList(),
            0.0,
            0.0,
            0
        )
        return cartRepository.createCart(cart)?.toCartDomain()
    }

    fun findCartById(cartId: String): Cart? {
        return cartRepository.findUserCart(cartId)?.toCartDomain()
    }

    fun addCartItem(userId: String,request: AddItemRequest) : String{
        val cart = cartRepository.findCartByUserId(userId)?.toCartDomain()
        val product = productService.getProductByProductId(request.productId)
        val user = userService.findUserById(userId)

        if (!cartItemService.isCartItemExists(cart, product, request.size, userId)) {
            val newCartItem = CartItem(
                generatedUniqueId(),
                user,
                cart,
                product,
                request.size,
                request.quantity,
                price = (request.quantity * request.price),
                discountedPrice = (request.price - request.discountedPrice) * request.quantity
            )

            val createdCartItem = cartItemService.createCartItem(newCartItem)
            cart?.cartItems?.addLast(createdCartItem)
            if (cart != null) {
                cartRepository.updateCart(userId, cart.toCartDTO())
            }
        }
        return "Item Added to Cart"
    }

    fun findUserCart(userId: String): Cart? {
        val cart = cartRepository.findCartByUserId(userId)?.toCartDomain();

        var totalPrice = 0.0
        var totalDiscountedPrice= 0.0
        var totalItem = cart?.cartItems?.size ?: 0

        for (cartItem in cart?.cartItems!!) {
            totalPrice = (totalPrice + cartItem?.price!!) ?: 0.0
            totalDiscountedPrice = (totalDiscountedPrice + cartItem.discountedPrice) ?: 0.0
            totalItem += cartItem.quantity
        }

        val cartDTO = CartDTO(
            cart.cartId,
            userId,
            cart.cartItems.stream().map{ it?.cartItemId }?.toList() ?: emptyList(),
            totalPrice,
            totalDiscountedPrice,
            totalItem
        )

        return cartRepository.updateCart(cart.cartId, cartDTO)?.toCartDomain()

    }
    fun CartDTO.toCartDomain() = Cart(
        cartId,
        userService.findUserById(userId ?: ""),
        cartItems?.stream()?.map{ it -> cartItemService.findCartItemById(it) }?.toList() ?: emptyList(),
        totalPrice,
        totalDiscountedPrice,
        quantity
    )

    fun Cart.toCartDTO() = CartDTO(
        cartId,
        user?.userId,
        cartItems?.stream()?.map { it?.cartItemId ?: "000" }?.toList() ?: emptyList(),
        totalPrice,
        totalDiscountedPrice,
        quantity
    )


}