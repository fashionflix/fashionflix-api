package com.fashionflix.fashionflixapi.common.clients.db.cartItem

import com.fashionflix.fashionflixapi.exception.CartItemException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class CartItemRepository(
    @Autowired val mongoTemplate: MongoTemplate
) {

    fun createCartItem(cartItem: CartItemDTO): CartItemDTO? {
        return null
    }

    @Throws(CartItemException::class)
    fun updateCartItem(userId:String, cartId: String, cartItem: CartItemDTO): CartItemDTO? {
        return null
    }
    @Throws(CartItemException::class)
    fun isCartItemExist(cartItemId: String?, productId: String?, size: String,  userId: String): Boolean {
        return true
    }
    @Throws(CartItemException::class)
    fun removeCartItem(userId: String, cartItemId: String) {
    }

    @Throws(CartItemException::class)
    fun findCartItemById(cartItem: String): CartItemDTO? {
        return null
    }

    @Throws(CartItemException::class)
    fun findCartItemByUserId(cartItem: String): CartItemDTO? {
        return null
    }
}