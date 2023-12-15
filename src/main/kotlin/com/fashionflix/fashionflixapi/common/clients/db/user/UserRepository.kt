package com.fashionflix.fashionflixapi.common.clients.db.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.FindAndReplaceOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.server.ResponseStatusException

@Repository
class UserRepository(@Autowired val mongoTemplate: MongoTemplate){
    fun findUserById(userId: String): UserDTO? {
        val criteria = Criteria.where("userId").`is`(userId)
        val query = Query().addCriteria(criteria)

        return mongoTemplate.findOne(query, UserDTO::class.java)
    }

    fun findUserByEmail(email: String): UserDTO? {
        val criteria = Criteria.where("email").`is`(email)
        val query = Query().addCriteria(criteria)

        return mongoTemplate.findOne(query, UserDTO::class.java)
    }

    fun createUser(user: UserDTO) {
        val criteria = Criteria.where("email").`is`(user.email)

        val query = Query().addCriteria(criteria)

        if(mongoTemplate.exists(query, UserDTO::class.java)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "User already exists")
        } else {
            mongoTemplate.findAndReplace(query, user, FindAndReplaceOptions().upsert())
        }
    }

}