package com.fashionflix.fashionflixapi.exception

class UserException( message: String): Exception(message) {
}

class ProductException(message: String) : Exception(message)

class CategoryException(message: String): Exception(message)

class OrderException(message: String): Exception(message)
class CartItemException(message: String): Exception(message)
