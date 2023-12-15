package com.fashionflix.fashionflixapi.service

import com.fashionflix.fashionflixapi.common.clients.db.category.CategoryDTO
import com.fashionflix.fashionflixapi.common.clients.db.category.CategoryRepository
import com.fashionflix.fashionflixapi.common.constants.generatedUniqueId
import com.fashionflix.fashionflixapi.model.Category
import com.fashionflix.fashionflixapi.schema.CreateCategoryRequest
import org.springframework.stereotype.Service

@Service
class CategoryService(
    val categoryRepository: CategoryRepository
) {

    fun createCategory(request: CreateCategoryRequest): Category? {
        val newCategory = CategoryDTO(
            generatedUniqueId(),
            request.name,
            request.value
        )
        return categoryRepository.createCategory(newCategory)?.toCategoryDomain()
    }

    fun updateCategory(categoryId: String, request: CreateCategoryRequest): Category? {
        val updatedCategory = CategoryDTO(
            categoryId,
            request.name,
            request.value
        )
        return categoryRepository.updateCategory(categoryId, updatedCategory)?.toCategoryDomain()
    }

    fun deleteCategory(categoryId:String) {
        return categoryRepository.deleteCategory(categoryId)
    }

    fun getCategory(value: String): Category? {
        return categoryRepository.findByValue(value)?.toCategoryDomain()
    }

    fun getAllCategory(): List<Category>? {
        return  categoryRepository.findAllCategory().map { it.toCategoryDomain()}
    }
}