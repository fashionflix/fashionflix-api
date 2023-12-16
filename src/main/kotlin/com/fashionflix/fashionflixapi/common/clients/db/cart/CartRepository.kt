package com.fashionflix.fashionflixapi.common.clients.db.cart

import com.fashionflix.fashionflixapi.common.clients.db.user.UserDTO
import com.fashionflix.fashionflixapi.common.constants.generatedUniqueId
import com.fashionflix.fashionflixapi.exception.ProductException
import com.fashionflix.fashionflixapi.schema.AddItemRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.FindAndReplaceOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
class CartRepository(@Autowired val mongoTemplate: MongoTemplate) {

    fun createCart(cartDTO: CartDTO): CartDTO? {

        val query = Query()
        return mongoTemplate.findAndReplace(query, cartDTO, FindAndReplaceOptions().upsert())
    }

    fun updateCart(cartId: String, cartDTO: CartDTO): CartDTO? {
        val query = Query()
        val criteria = Criteria.where("cartId").`is`(cartId)
        query.addCriteria(criteria)

        return mongoTemplate.findAndReplace(query, cartDTO, FindAndReplaceOptions().upsert())
    }

    fun findCartByUserId(id: String): CartDTO? {
        val query = Query().addCriteria(Criteria.where("userId").`is`(id))

        return mongoTemplate.findOne(query, CartDTO::class.java)
    }

    fun findUserCart(userId: String): CartDTO? {
        return null
    }
}