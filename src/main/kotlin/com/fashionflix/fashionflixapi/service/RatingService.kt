package com.fashionflix.fashionflixapi.service

import com.fashionflix.fashionflixapi.common.clients.db.rating.RatingDTO
import com.fashionflix.fashionflixapi.common.clients.db.rating.RatingRepository
import com.fashionflix.fashionflixapi.common.constants.generatedUniqueId
import com.fashionflix.fashionflixapi.model.Rating
import com.fashionflix.fashionflixapi.model.User
import com.fashionflix.fashionflixapi.schema.RatingRequest
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class RatingService(
    val ratingRepository: RatingRepository,
    val productService: ProductService,
    val userService: UserService
) {

    fun createRating(user: User, request: RatingRequest): Rating? {
        val product = productService.getProductByProductId(request.productId)

        val rating = Rating(
            generatedUniqueId(),
            product,
            user,
            request.rating,
            Instant.now()
        )

        return ratingRepository.createRating(rating.toRatingDTO())?.toRatingDomain()
    }

    fun getAllProductRating(productId: String): List<Rating>? {
        return ratingRepository.getAllProductRating(productId)
            ?.stream()?.map{ it.toRatingDomain()}?.toList() ?: emptyList()
    }

    fun Rating.toRatingDTO() = RatingDTO(
        ratingId,
        product?.productId,
        user?.userId,
        rating,
        createdAt
    )

    fun RatingDTO.toRatingDomain() = Rating(
        ratingId,
        productService.getProductByProductId(productId ?: "" ),
        userService.findUserById(userId ?: ""),
        rating,
        createdAt
    )
}