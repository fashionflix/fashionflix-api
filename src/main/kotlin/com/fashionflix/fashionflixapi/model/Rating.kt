package com.fashionflix.fashionflixapi.model

import java.time.Instant

data class Rating (
    val ratingId: String,
    val productId: String,
    val customerId: String,
    val rating: Float,
    val createdAt: Instant
) {
}