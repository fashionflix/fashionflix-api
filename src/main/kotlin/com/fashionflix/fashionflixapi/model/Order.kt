package com.fashionflix.fashionflixapi.model

import com.fashionflix.fashionflixapi.schema.OrderItem
import com.fashionflix.fashionflixapi.schema.PaymentDetails
import java.time.Instant

class Order(
    val orderId: String,
    val product: Product,
    val user: User,
    val orderItems: List<OrderItem> = emptyList(),
    val deliveryDate: Instant,
    val createdAt: Instant,
    val shippingAddressId: String,
    val paymentDetails: PaymentDetails,
    val totalPrice: Float,
    val totalDiscountedPrice: Float,
    val discount: Float,
    val orderStatus: String,
    val totalItem: Int
){
}