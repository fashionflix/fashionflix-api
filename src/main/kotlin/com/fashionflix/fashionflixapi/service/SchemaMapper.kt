package com.fashionflix.fashionflixapi.service

import com.fashionflix.fashionflixapi.common.clients.db.address.AddressDTO
import com.fashionflix.fashionflixapi.common.clients.db.category.CategoryDTO
import com.fashionflix.fashionflixapi.common.clients.db.product.ProductDTO
import com.fashionflix.fashionflixapi.common.clients.db.user.UserDTO
import com.fashionflix.fashionflixapi.model.Address
import com.fashionflix.fashionflixapi.model.Category
import com.fashionflix.fashionflixapi.model.Product
import com.fashionflix.fashionflixapi.model.User
fun UserDTO.toUserDomain() = User(
    userId,
    firstName,
    lastName,
    password,
    email,
    role,
    mobile,
    createdAt
)

fun AddressDTO.toAddressDomain() = Address(
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

fun ProductDTO.toProductDomain() = Product(
    productId,
    title,
    description,
    brand,
    imageUrl,
    color,
    sizes,
    price,
    discountedPrice,
    discountedPercent,
    quantity,
    categoryId,
    createdAt
)

fun CategoryDTO.toCategoryDomain() = Category(
    categoryId,
    name,
    value
)