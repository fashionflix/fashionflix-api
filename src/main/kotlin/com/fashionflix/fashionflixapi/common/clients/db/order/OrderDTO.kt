package com.fashionflix.fashionflixapi.common.clients.db.order

import com.fashionflix.fashionflixapi.common.clients.db.user.UserDTO
import com.fashionflix.fashionflixapi.schema.OrderItem
import com.fashionflix.fashionflixapi.schema.PaymentDetails
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference
import java.time.Instant

@Document("order")
class OrderDTO (
    val orderId: String,
    val productId: String,
    val userId: String?,
    val orderItems: List<String> = emptyList(),
    val deliveryDate: Instant,
    val createdAt: Instant,
    val shippingAddressId: String,
    val paymentDetailId: String?,
    val totalPrice: Float,
    val totalDiscountedPrice: Float,
    val discount: Float,
    val orderStatus: String,
    val totalItem: Int
){
}