package com.fashionflix.fashionflixapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import org.springframework.data.mongodb.core.mapping.Field

data class User(
    @Id
    val userId: String,
    @Field("first_name")
    val firstName: String,
    @Field("last_name")
    val lastName: String,
    val password: String,
    val email: String,
    val role: String,
    val mobile: String,
    val createdAt: Instant
)