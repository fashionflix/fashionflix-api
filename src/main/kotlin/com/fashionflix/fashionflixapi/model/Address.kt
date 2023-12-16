package com.fashionflix.fashionflixapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field

data class Address(
    val addressId: String,
    val user: User?,
    val firstName: String,
    val lastName: String,
    val streetAddress: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val mobile: String
)