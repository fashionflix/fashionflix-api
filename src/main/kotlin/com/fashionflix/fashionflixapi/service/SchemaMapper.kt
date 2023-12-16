package com.fashionflix.fashionflixapi.service

import com.fashionflix.fashionflixapi.common.clients.db.address.AddressDTO
import com.fashionflix.fashionflixapi.common.clients.db.cart.CartDTO
import com.fashionflix.fashionflixapi.common.clients.db.cartItem.CartItemDTO
import com.fashionflix.fashionflixapi.common.clients.db.cartItem.CartItemRepository
import com.fashionflix.fashionflixapi.common.clients.db.category.CategoryDTO
import com.fashionflix.fashionflixapi.common.clients.db.product.ProductDTO
import com.fashionflix.fashionflixapi.common.clients.db.user.UserDTO
import com.fashionflix.fashionflixapi.model.*

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

fun AddressDTO.toAddressDomain(user: User?) = Address(
    addressId,
    user,
    firstName,
    lastName,
    streetAddress,
    city,
    state,
    zipCode,
    mobile
)

fun ProductDTO.toProductDomain(category: Category?) = Product(
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
    category,
    createdAt
)

fun CategoryDTO.toCategoryDomain() = Category(
    categoryId,
    name,
    value
)