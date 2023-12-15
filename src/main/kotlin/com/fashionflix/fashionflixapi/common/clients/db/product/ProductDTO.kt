package com.fashionflix.fashionflixapi.common.clients.db.product

import com.fashionflix.fashionflixapi.model.Size
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document("product")
data class ProductDTO(
    val productId: String,
    val title: String,
    val description: String,
    val brand: String,
    val imageUrl: String,
    val color: String,
    val sizes: List<String> = emptyList(),
    val price: Float,
    val discountedPrice: Float,
    val discountedPercent: Float,
    val quantity: Int,
    val categoryId: String,
    val createdAt: Instant
){

}