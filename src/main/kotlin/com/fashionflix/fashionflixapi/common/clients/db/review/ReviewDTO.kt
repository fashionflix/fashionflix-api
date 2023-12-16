package com.fashionflix.fashionflixapi.common.clients.db.review

import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
@Document("review")
data class ReviewDTO (
    val reviewId: String,
    val review: String,
    val productId: String?,
    val userId: String?,
    val createdAt: Instant
)