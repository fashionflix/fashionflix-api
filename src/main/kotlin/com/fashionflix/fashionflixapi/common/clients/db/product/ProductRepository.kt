package com.fashionflix.fashionflixapi.common.clients.db.product

import com.fashionflix.fashionflixapi.exception.ProductException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.core.FindAndReplaceOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.support.PageableExecutionUtils
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.server.ResponseStatusException
import java.time.Instant
import java.util.UUID

@Repository
class ProductRepository(
    @Autowired val mongoTemplate: MongoTemplate
) {
    @Throws(ProductException::class)
    fun createProduct(productDTO: ProductDTO): ProductDTO? {
        val query = Query().addCriteria(Criteria.where("productId").`is`(productDTO.productId))
        if(mongoTemplate.exists(query, ProductDTO::class.java)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "Product already exists")
        } else {
            return mongoTemplate.findAndReplace(query, productDTO, FindAndReplaceOptions().upsert())
        }
    }

    @Throws(ProductException::class)
    fun deleteProduct(productId: String) {
        val query = Query().addCriteria(Criteria.where("productId").`is`(productId))

        if (!mongoTemplate.exists(query, ProductDTO::class.java))
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Exists")
        else
            mongoTemplate.remove(query, ProductDTO::class.java)
    }
    @Throws(ProductException::class)
    fun updateProduct(productId: String, productDTO: ProductDTO): ProductDTO? {
        val query = Query().addCriteria(Criteria.where("productId").`is`(productId))

        if(!mongoTemplate.exists(query, ProductDTO::class.java)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "Product Not exists")
        } else {
            return mongoTemplate.findAndReplace(query, productDTO, FindAndReplaceOptions().upsert())
        }
    }

    @Throws(ProductException::class)
    fun findProductByProductId(productId: String): ProductDTO? {
        val query = Query()
        val criteria = Criteria.where("productId").`is`(productId)
        query.addCriteria(criteria)

        return mongoTemplate.findOne(query, ProductDTO::class.java)
    }

    fun findProductByCategory(category: String): List<ProductDTO> {
        val query = Query()
        val criteria = Criteria.where("category").`is`(category)
        query.addCriteria(criteria)

        return mongoTemplate.find(query, ProductDTO::class.java)
    }

    fun getAllProductPage(pageable: Pageable, criteria: Criteria?): Page<ProductDTO?> {
        val productQuery = Query()
        val countQuery = Query()

        return if (criteria == null) {
            Page.empty()
        }else {
            productQuery.addCriteria(criteria)
            countQuery.addCriteria(criteria)

            productQuery.with(pageable)
            val filteredProducts = mongoTemplate.find(productQuery, ProductDTO::class.java)
            val count = mongoTemplate.count(countQuery, ProductDTO::class.java)

            PageableExecutionUtils.getPage(
                filteredProducts,
                pageable
            ) { count }
        }
    }

}