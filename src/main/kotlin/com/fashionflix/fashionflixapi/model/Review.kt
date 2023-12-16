package com.fashionflix.fashionflixapi.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

data class Review (
    val reviewId: String,
    val review: String,
    val product: Product?,
    val user: User?,
    val createdAt: Instant
)