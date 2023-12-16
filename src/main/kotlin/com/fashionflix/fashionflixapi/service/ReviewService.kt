package com.fashionflix.fashionflixapi.service

import com.fashionflix.fashionflixapi.common.clients.db.review.ReviewDTO
import com.fashionflix.fashionflixapi.common.clients.db.review.ReviewRepository
import com.fashionflix.fashionflixapi.common.constants.generatedUniqueId
import com.fashionflix.fashionflixapi.model.Review
import com.fashionflix.fashionflixapi.model.User
import com.fashionflix.fashionflixapi.schema.ReviewRequest
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class ReviewService(
    val reviewRepository: ReviewRepository,
    val productService: ProductService,
    val userService: UserService
) {

    fun createReview(user: User, request: ReviewRequest): Review? {
        val product = productService.getProductByProductId(request.productId)

        val review = Review(
            generatedUniqueId(),
            request.review,
            product,
            user,
            Instant.now()
        )

        return reviewRepository.createReview(review.toReviewDTO())?.toReviewDomain()

    }

    fun getAllReview(productId: String): List<Review>? {
        return reviewRepository.getAllProductReview(productId)
            ?.stream()?.map{ it.toReviewDomain()}?.toList() ?: emptyList()
    }

    fun Review.toReviewDTO() = ReviewDTO(
        reviewId,
        product?.productId ?: "",
        review,
        user?.userId ?: "",
        createdAt
    )

    fun ReviewDTO.toReviewDomain() = Review(
        reviewId,
        review,
        productService.getProductByProductId(productId ?: ""),
        userService.findUserById(userId ?: ""),
        createdAt
    )
}