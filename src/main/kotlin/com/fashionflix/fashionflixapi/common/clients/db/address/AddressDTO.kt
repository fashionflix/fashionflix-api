package com.fashionflix.fashionflixapi.common.clients.db.address

import com.fashionflix.fashionflixapi.common.clients.db.user.UserDTO
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import org.springframework.data.mongodb.core.mapping.Field

@Document("address")
data class AddressDTO(
    val addressId: String,
    val userId: String?,
    @Field("first_name")
    val firstName: String,
    @Field("last_name")
    val lastName: String,
    @Field("street_address")
    val streetAddress: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val mobile: String
)