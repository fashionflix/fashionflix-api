package com.fashionflix.fashionflixapi.common.clients.db.review

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class ReviewRepository(@Autowired val mongoTemplate: MongoTemplate) {
}