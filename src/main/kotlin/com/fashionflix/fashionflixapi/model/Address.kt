package com.fashionflix.fashionflixapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field

data class Address(
    @Id
    val addressId: Long,
    @Field("first_name")
    val firstName: String,
    @Field("last_name")
    val lastName: String,
    @Field("street_address")
    val streetAddress: String,
    val customerId: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val mobile: String
)