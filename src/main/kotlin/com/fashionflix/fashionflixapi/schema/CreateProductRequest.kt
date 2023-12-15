package com.fashionflix.fashionflixapi.schema

import com.fashionflix.fashionflixapi.model.Size

data class CreateProductRequest(
    val title: String,
    val description: String,
    val price: Float,
    val discountedPrice: Float,
    val discountedPercent: Float,
    val quantity: Int,
    val brand: String,
    val color: String,
    val sizes:  List<String> = emptyList(),
    val imageUrl: String,
    val categoryId: String
)