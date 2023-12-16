package com.fashionflix.fashionflixapi.service

import com.fashionflix.fashionflixapi.common.clients.db.cart.CartRepository
import com.fashionflix.fashionflixapi.common.clients.db.order.OrderRepository

class OrderService(
    val orderRepository: OrderRepository,
    val cartRepository: CartRepository,
    val cartItemService: CartItemService,
    val productService: ProductService
) {
}