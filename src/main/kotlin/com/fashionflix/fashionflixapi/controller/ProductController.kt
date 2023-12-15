package com.fashionflix.fashionflixapi.controller

import com.fashionflix.fashionflixapi.model.Product
import com.fashionflix.fashionflixapi.schema.CreateProductRequest
import com.fashionflix.fashionflixapi.schema.ProductPage
import com.fashionflix.fashionflixapi.schema.ProductPageInput
import com.fashionflix.fashionflixapi.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.math.min

@RestController
@RequestMapping("/product")
class ProductController(
    @Autowired val productService: ProductService
) {

    @PostMapping("/create")
    fun createProduct(createProductRequest: CreateProductRequest): ResponseEntity<Product?> {
        return ResponseEntity(productService.createProduct(createProductRequest), HttpStatus.CREATED)
    }

    @PutMapping("/update")
    fun updateProduct(productId: String, createProductRequest: CreateProductRequest): ResponseEntity<Product?> {
        return ResponseEntity(productService.updateProduct(productId, createProductRequest), HttpStatus.OK)
    }

    @GetMapping("/productId")
    fun getProduct(productId: String): ResponseEntity<Product?> {
        return ResponseEntity(productService.getProductByProductId(productId), HttpStatus.OK)
    }

    @DeleteMapping("/productId")
    fun deleteProduct(productId: String): ResponseEntity<Any> {
        return ResponseEntity(productService.deleteProduct(productId), HttpStatus.OK)
    }

    @GetMapping("/products")
    fun getAllProductPage(
        pageNumber: Int,
        pageSize: Int,
        @RequestParam category: String,
        @RequestParam minPrice: Int,
        @RequestParam maxPrice: Int,
        @RequestParam sort: String
    ): ResponseEntity<ProductPage?>{

        val input = ProductPageInput(
            category,
            minPrice,
            maxPrice,
            pageSize,
            pageNumber,
            sort
        )
        return ResponseEntity(productService.getAllProductPage(input), HttpStatus.OK)
    }
}