package com.fashionflix.fashionflixapi.model

import java.time.Instant

data class Product(
    val productId: String,
    val title: String,
    val description: String,
    val brand: String,
    val imageUrl: String,
    val color: String,
    val sizes: List<String>,
    val price: Float,
    val discountedPrice: Float,
    val discountedPercent: Float,
    val quantity: Int,
    val categoryId: String,
    val createdAt: Instant
) {
}