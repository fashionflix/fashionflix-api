package com.fashionflix.fashionflixapi.common.clients.db.order

import com.fashionflix.fashionflixapi.exception.OrderException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class OrderRepository (
    @Autowired val mongoTemplate: MongoTemplate,
){
    @Throws(OrderException::class)
    fun createOrder(userId: String, addressId: String): OrderDTO? {
        return null
    }
    @Throws(OrderException::class)
    fun findOrderById(orderId: String): OrderDTO? {
        return null
    }
    @Throws(OrderException::class)
    fun userOrderHistory(userId: String): List<OrderDTO>? {
        return null
    }
    @Throws(OrderException::class)
    fun placedOrder(orderId: String): OrderDTO? {
        return null
    }
    @Throws(OrderException::class)
    fun confirmedOrder(orderId: String): OrderDTO? {
        return null
    }
    @Throws(OrderException::class)
    fun shippedOrder(orderId: String): OrderDTO? {
        return null
    }

    @Throws(OrderException::class)
    fun deliveredOrder(orderId: String): OrderDTO? {
        return null
    }

    @Throws(OrderException::class)
    fun cancelledOrder(orderId: String): OrderDTO? {
        return null
    }

    fun getAllOrders(): List<OrderDTO>? {
        return null
    }
    @Throws(OrderException::class)
    fun deleteOrder(orderId: String) {
    }


}