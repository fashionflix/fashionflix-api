package com.fashionflix.fashionflixapi.common.clients.db.rating

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class RatingRepository(@Autowired val mongoTemplate: MongoTemplate) {
}