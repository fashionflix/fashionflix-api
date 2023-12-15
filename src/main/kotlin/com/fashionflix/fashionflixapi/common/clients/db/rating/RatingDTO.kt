package com.fashionflix.fashionflixapi.common.clients.db.rating

import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document("rating")
data class RatingDTO (
    val ratingId: String,
    val productId: String,
    val customerId: String,
    val rating: Float,
    val createdAt: Instant
)