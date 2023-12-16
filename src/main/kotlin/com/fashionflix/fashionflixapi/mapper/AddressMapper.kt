package com.fashionflix.fashionflixapi.mapper

import com.fashionflix.fashionflixapi.common.clients.db.address.AddressDTO
import com.fashionflix.fashionflixapi.model.Address

fun Address.toAddressDTO() = AddressDTO(
    addressId,
    user?.userId,
    firstName,
    lastName,
    streetAddress,
    city,
    state,
    zipCode,
    mobile
)