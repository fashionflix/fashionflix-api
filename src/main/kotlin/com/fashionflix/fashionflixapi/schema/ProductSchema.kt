package com.fashionflix.fashionflixapi.schema

import com.fashionflix.fashionflixapi.model.Product

class ProductPageInput (
    val category: String,
    val minPrice: Int,
    val maxPrice: Int,
    val pageSize: Int,
    val pageNumber: Int,
    val sort: String
)

class ProductPage(
    val rows: List<Product?>,
    val totalPages: Long,
    val totalRecords: Long
)