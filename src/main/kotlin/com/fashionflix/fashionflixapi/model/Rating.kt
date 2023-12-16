package com.fashionflix.fashionflixapi.model

import java.time.Instant

data class Rating (
    val ratingId: String,
    val product: Product?,
    val user: User?,
    val rating: Double,
    val createdAt: Instant
) {
}