package com.fashionflix.fashionflixapi.model

class CartItem(
    val cartItemId: String,
    val user: User?,
    val cart: Cart?,
    val product: Product?,
    val size: String,
    val quantity: Int,
    val price: Float,
    val discountedPrice: Float
) {
}