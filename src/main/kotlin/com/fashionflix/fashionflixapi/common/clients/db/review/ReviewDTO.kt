package com.fashionflix.fashionflixapi.common.clients.db.review

import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
@Document
data class ReviewDTO(
    val reviewId: String,
    val review: String,
    val productId: String,
    val customerId: String,
    val createdAt: Instant
)