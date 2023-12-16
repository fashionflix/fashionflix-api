package com.fashionflix.fashionflixapi.schema

class AddItemRequest(
    val productId: String,
    val size: String,
    val quantity: Int,
    val price: Float,
    val discountedPrice: Float
) {
}