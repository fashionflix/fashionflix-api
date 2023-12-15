package com.fashionflix.fashionflixapi.common.clients.db.category

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("category")
class CategoryDTO(

    val categoryId: String,
    val name: String,
    val value: String
) {
}