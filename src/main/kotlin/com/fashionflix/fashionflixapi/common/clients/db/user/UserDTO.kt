package com.fashionflix.fashionflixapi.common.clients.db.user

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "user")
data class UserDTO(
    val userId: String,
    @Field("first_name")
    val firstName: String,
    @Field("last_name")
    val lastName: String,
    val password: String,
    val email: String,
    val role: String,
    val mobile: String,
    val createdAt: Instant,
    val addressList: List<String> ?= null
)