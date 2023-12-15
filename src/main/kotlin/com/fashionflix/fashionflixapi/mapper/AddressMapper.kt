package com.fashionflix.fashionflixapi.mapper

import com.fashionflix.fashionflixapi.common.clients.db.address.AddressDTO
import com.fashionflix.fashionflixapi.model.Address

fun Address.toAddressDTO() = AddressDTO(
    addressId,
    firstName,
    lastName,
    streetAddress,
    customerId,
    city,
    state,
    zipCode,
    mobile
)