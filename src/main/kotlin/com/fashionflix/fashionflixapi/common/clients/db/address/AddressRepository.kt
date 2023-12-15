package com.fashionflix.fashionflixapi.common.clients.db.address

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
class AddressRepository(@Autowired val mongoTemplate: MongoTemplate){
    fun findAddressById(addressId: String): AddressDTO? {
        val criteria = Criteria.where("addressId").`is`(addressId)
        val query = Query().addCriteria(criteria)

        return mongoTemplate.findOne(query, AddressDTO::class.java)
    }

    fun findAddressByUserId(userId: String): List<AddressDTO>? {
        val criteria = Criteria.where("userId").`is`(userId)
        val query = Query().addCriteria(criteria)

        return mongoTemplate.find(query, AddressDTO::class.java)
    }
}