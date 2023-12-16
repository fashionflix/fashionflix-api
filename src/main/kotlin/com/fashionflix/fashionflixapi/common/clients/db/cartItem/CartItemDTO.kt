package com.fashionflix.fashionflixapi.common.clients.db.cartItem

import com.fashionflix.fashionflixapi.common.clients.db.cart.CartDTO
import com.fashionflix.fashionflixapi.common.clients.db.product.ProductDTO
import com.fashionflix.fashionflixapi.common.clients.db.user.UserDTO
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference

@Document("cart_item")
class CartItemDTO (
    val cartItemId: String,
    val userId: String,
    val cartId: String,
    val productId: String,
    val size: String,
    val quantity: Int,
    val price: Float,
    val discountedPrice: Float
){
}