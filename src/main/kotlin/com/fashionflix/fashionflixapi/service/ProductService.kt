package com.fashionflix.fashionflixapi.service

import com.fashionflix.fashionflixapi.common.clients.db.category.CategoryRepository
import com.fashionflix.fashionflixapi.common.clients.db.product.ProductDTO
import com.fashionflix.fashionflixapi.common.clients.db.product.ProductRepository
import com.fashionflix.fashionflixapi.common.constants.generatedUniqueId
import com.fashionflix.fashionflixapi.model.Product
import com.fashionflix.fashionflixapi.schema.CreateProductRequest
import com.fashionflix.fashionflixapi.schema.ProductPage
import com.fashionflix.fashionflixapi.schema.ProductPageInput
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class ProductService(val productRepository: ProductRepository, val categoryRepository: CategoryRepository) {

    fun createProduct(request: CreateProductRequest): Product? {

        val category = categoryRepository.findById(request.categoryId)?.toCategoryDomain()

        val newProduct = ProductDTO(
            generatedUniqueId(),
            request.title,
            request.description,
            request.brand,
            request.imageUrl,
            request.color,
            request.sizes,
            request.price,
            request.discountedPrice,
            request.discountedPercent,
            request.quantity,
            request.categoryId,
            Instant.now()
        )
        return productRepository.createProduct(newProduct)?.toProductDomain(category)
    }

    fun updateProduct(productId:String, request: CreateProductRequest): Product? {

        val category = categoryRepository.findById(request.categoryId)?.toCategoryDomain()
        val updatedProduct = ProductDTO(
            productId,
            request.title,
            request.description,
            request.brand,
            request.imageUrl,
            request.color,
            request.sizes,
            request.price,
            request.discountedPrice,
            request.discountedPercent,
            request.quantity,
            request.categoryId,
            Instant.now()
        )
        return productRepository.updateProduct(productId, updatedProduct)?.toProductDomain(category)
    }

    fun deleteProduct(productId:String) {
        return productRepository.deleteProduct(productId)
    }

    fun getProductByProductId(productId: String): Product? {
        val product = productRepository.findProductByProductId(productId)
        val category = categoryRepository.findById(product?.categoryId)?.toCategoryDomain()

        return product?.toProductDomain(category)
    }
    fun getAllProductPage(productPageInput: ProductPageInput): ProductPage {
        val sort = setSort(productPageInput.sort)
        val criteria = Criteria.where("categoryId").`is`(productPageInput.categoryId)
        val category = categoryRepository.findById(productPageInput.categoryId)?.toCategoryDomain()

        val page = PageRequest.of(productPageInput.pageNumber, productPageInput.pageSize, sort)
        val result: Page<Product?> = productRepository.getAllProductPage(page, criteria).map { it?.toProductDomain(category) }

        return ProductPage(rows = result.toList().map{ it }, totalPages = result.totalPages.toLong(), totalRecords = result.totalElements)
    }

    fun setSort(column: String) : Sort {
        return if (column.isNullOrEmpty()) {
            Sort.by(Sort.Direction.DESC, "createdAt")
        } else {
            Sort.by(Sort.Direction.DESC, column)
        }
    }
}