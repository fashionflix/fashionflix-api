package com.fashionflix.fashionflixapi.model


import java.time.Instant

data class User(
    val userId: String,
    val firstName: String,
    val lastName: String,
    val password: String,
    val email: String,
    val role: String,
    val mobile: String,
    val createdAt: Instant,
    val addressList: List<Address> ?= emptyList()
)