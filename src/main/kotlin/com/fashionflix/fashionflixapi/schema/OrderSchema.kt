package com.fashionflix.fashionflixapi.schema

import java.time.Instant

class OrderItem (
    val orderId: String,
    val productId: String,
    val userId: String,
    val size: String,
    val quantity: Int,
    val price: Float,
    val discountedPrice: Float,
    val deliveryDate: Instant
) {
}