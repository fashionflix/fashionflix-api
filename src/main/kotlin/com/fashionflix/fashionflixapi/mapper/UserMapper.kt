package com.fashionflix.fashionflixapi.mapper


import com.fashionflix.fashionflixapi.common.clients.db.user.UserDTO
import com.fashionflix.fashionflixapi.common.clients.db.user.UserRepository
import com.fashionflix.fashionflixapi.model.User
import java.util.stream.Collectors

fun User.toUserDTO() = UserDTO(
    userId,
    firstName,
    lastName,
    password,
    email,
    role,
    mobile,
    createdAt,
    addressList = addressList?.stream()?.map { it.addressId }?.toList() ?: emptyList()
)