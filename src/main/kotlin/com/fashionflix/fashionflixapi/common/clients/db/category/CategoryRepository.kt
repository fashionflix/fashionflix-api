package com.fashionflix.fashionflixapi.common.clients.db.category

import com.fashionflix.fashionflixapi.common.clients.db.product.ProductDTO
import com.fashionflix.fashionflixapi.common.clients.db.user.UserDTO
import com.fashionflix.fashionflixapi.exception.CategoryException
import com.fashionflix.fashionflixapi.exception.ProductException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.FindAndReplaceOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.and
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Repository
class CategoryRepository(@Autowired val mongoTemplate: MongoTemplate){

    fun findByValue(value: String): CategoryDTO? {
        val criteria = Criteria.where("value").`is`(value)
        val query = Query().addCriteria(criteria)

        return mongoTemplate.findOne(query, CategoryDTO::class.java)
    }
    fun findAllCategory(): List<CategoryDTO> {
        val query = Query()
        return mongoTemplate.find(query, CategoryDTO::class.java)
    }

    @Throws(CategoryException::class)
    fun createCategory(categoryDTO: CategoryDTO): CategoryDTO? {

        val query = Query().addCriteria(Criteria.where("categoryId").`is`(categoryDTO.categoryId))

        if(mongoTemplate.exists(query, CategoryDTO::class.java)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "Category already exists")
        } else {
            return mongoTemplate.findAndReplace(query, categoryDTO, FindAndReplaceOptions().upsert())
        }
    }

    @Throws(CategoryException::class)
    fun updateCategory(categoryId: String, categoryDTO: CategoryDTO): CategoryDTO? {
        val query = Query().addCriteria(Criteria.where("categoryId").`is`(categoryId))

        if(!mongoTemplate.exists(query, CategoryDTO::class.java)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "Category Not exists")
        } else {
            return mongoTemplate.findAndReplace(query, categoryDTO, FindAndReplaceOptions().upsert())
        }
    }
    @Throws(CategoryException::class)
    fun deleteCategory(categoryId: String) {
        val query = Query().addCriteria(Criteria.where("categoryId").`is`(categoryId))

        if (!mongoTemplate.exists(query, CategoryDTO::class.java))
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Category Not Exists")
        else
            mongoTemplate.remove(query, CategoryDTO::class.java)
    }

}