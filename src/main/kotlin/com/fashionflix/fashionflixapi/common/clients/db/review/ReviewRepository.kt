package com.fashionflix.fashionflixapi.common.clients.db.review

import com.fashionflix.fashionflixapi.common.clients.db.product.ProductDTO
import com.fashionflix.fashionflixapi.common.clients.db.rating.RatingDTO
import com.fashionflix.fashionflixapi.exception.ProductException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.FindAndReplaceOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.server.ResponseStatusException

@Repository
class ReviewRepository(@Autowired val mongoTemplate: MongoTemplate) {

    @Throws(ProductException::class)
    fun createReview(reviewDTO: ReviewDTO): ReviewDTO? {
        val query = Query().addCriteria(Criteria.where("reviewId").`is`(reviewDTO.reviewId))
        if(mongoTemplate.exists(query, ReviewDTO::class.java)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "Review already exists")
        } else {
            return mongoTemplate.findAndReplace(query, reviewDTO, FindAndReplaceOptions().upsert())
        }
    }
    fun getAllProductReview(productId: String): List<ReviewDTO>? {
        val query = Query().addCriteria(Criteria.where("productId").`is`(productId))

        return mongoTemplate.find(query, ReviewDTO::class.java)
    }

}