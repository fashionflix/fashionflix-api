package com.fashionflix.fashionflixapi.common.clients.db.rating

import com.fashionflix.fashionflixapi.common.clients.db.product.ProductDTO
import com.fashionflix.fashionflixapi.common.clients.db.user.UserDTO
import com.fashionflix.fashionflixapi.exception.ProductException
import com.fashionflix.fashionflixapi.schema.RatingRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.FindAndReplaceOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.server.ResponseStatusException

@Repository
class RatingRepository(@Autowired val mongoTemplate: MongoTemplate) {

    @Throws(ProductException::class)
    fun createRating(ratingDTO: RatingDTO): RatingDTO? {
        val query = Query().addCriteria(Criteria.where("ratingId").`is`(ratingDTO.ratingId))
        if(mongoTemplate.exists(query, ProductDTO::class.java)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "Review already exists")
        } else {
            return mongoTemplate.findAndReplace(query, ratingDTO, FindAndReplaceOptions().upsert())
        }
    }

    fun getAllProductRating(productId: String): List<RatingDTO>? {
        val query = Query().addCriteria(Criteria.where("productId").`is`(productId))

        return mongoTemplate.find(query, RatingDTO::class.java)
    }
}