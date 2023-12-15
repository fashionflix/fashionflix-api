package com.fashionflix.fashionflixapi.controller

import com.fashionflix.fashionflixapi.model.Category
import com.fashionflix.fashionflixapi.schema.CreateCategoryRequest
import com.fashionflix.fashionflixapi.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/category")
class CategoryController (
    @Autowired val categoryService: CategoryService
){

    @PostMapping("/create")
    fun createCategory(createCategoryRequest: CreateCategoryRequest):ResponseEntity<Category?>{
        return ResponseEntity(categoryService.createCategory(createCategoryRequest), HttpStatus.CREATED)
    }

    @PutMapping("/update")
    fun updateCategory(categoryId: String, createCategoryRequest: CreateCategoryRequest): ResponseEntity<Category?> {
        return ResponseEntity(categoryService.updateCategory(categoryId, createCategoryRequest), HttpStatus.OK)
    }

    @DeleteMapping("/categoryId")
    fun deleteCategory(categoryId: String): ResponseEntity<Any> {
        return ResponseEntity(categoryService.deleteCategory(categoryId), HttpStatus.OK)
    }
    @GetMapping("/value")
    fun getCategory(value: String): ResponseEntity<Category?> {
        return ResponseEntity(categoryService.getCategory(value), HttpStatus.OK)
    }
    @GetMapping("/categories")
    fun getAllCategory(): ResponseEntity<List<Category>?> {
        return ResponseEntity(categoryService.getAllCategory(), HttpStatus.OK)
    }

}