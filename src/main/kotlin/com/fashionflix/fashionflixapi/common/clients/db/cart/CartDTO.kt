package com.fashionflix.fashionflixapi.common.clients.db.cart

import org.springframework.data.mongodb.core.mapping.Document

@Document("cart")
class CartDTO(
    val cartId: String,
    val userId: String?,
    val cartItems: List<String?> ?= emptyList(),
    val totalPrice: Double?,
    val totalDiscountedPrice: Double?,
    val quantity: Int
) {
}