package com.fashionflix.fashionflixapi.model

class Cart(
    val cartId: String,
    val user: User?,
    val cartItems: List<CartItem?>? = emptyList(),
    val totalPrice: Double?,
    val totalDiscountedPrice: Double?,
    val quantity: Int
){
}