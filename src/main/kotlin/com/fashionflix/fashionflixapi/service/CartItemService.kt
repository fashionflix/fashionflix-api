package com.fashionflix.fashionflixapi.service

import com.fashionflix.fashionflixapi.common.clients.db.cartItem.CartItemDTO
import com.fashionflix.fashionflixapi.common.clients.db.cartItem.CartItemRepository
import com.fashionflix.fashionflixapi.exception.CartItemException
import com.fashionflix.fashionflixapi.model.Cart
import com.fashionflix.fashionflixapi.model.CartItem
import com.fashionflix.fashionflixapi.model.Product
import org.springframework.stereotype.Service

@Service
class CartItemService(
    val cartItemRepository: CartItemRepository,
    val userService: UserService,
    val cartService: CartService,
    val productService: ProductService
) {

    fun createCartItem(cartItem: CartItem): CartItem? {
        return cartItemRepository.createCartItem(cartItem.toCartItemDTO())
            ?.toCartItemDomain()
    }

    fun findCartItemById(id: String?): CartItem? {
        if(id == null)
            return null
        return cartItemRepository.findCartItemByUserId(id)?.toCartItemDomain()
    }

    fun isCartItemExists(cart: Cart?, product: Product?, size: String, userId: String): Boolean {
        return cartItemRepository.isCartItemExist(cart?.cartId, product?.productId, size, userId)
    }

    @Throws(CartItemException::class)
    fun updateCartItem(userId:String, cartItemId: String, updatedCartItem: CartItem): CartItem? {

        val item = cartItemRepository.findCartItemById(cartItemId)
        val user = userService.findUserById(userId)

        return null
    }

    fun CartItemDTO.toCartItemDomain() = CartItem(
        cartItemId,
        userService.findUserById(userId),
        cartService.findCartById(cartId),
        productService.getProductByProductId(productId),
        size,
        quantity,
        price,
        discountedPrice
    )

    fun CartItem.toCartItemDTO() = CartItemDTO(
        cartItemId,
        user?.userId ?: "",
        cart?.cartId ?: "",
        product?.productId ?: "",
        size,
        quantity,
        price,
        discountedPrice
    )
}