package com.fashionflix.fashionflixapi.exception

class UserException( message: String): Exception(message) {
}

class ProductException(message: String) : Exception(message)

class CategoryException(message: String): Exception(message)