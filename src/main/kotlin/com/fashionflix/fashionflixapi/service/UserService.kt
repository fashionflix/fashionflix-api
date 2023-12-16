package com.fashionflix.fashionflixapi.service

import com.fashionflix.fashionflixapi.common.clients.db.user.UserRepository
import com.fashionflix.fashionflixapi.mapper.toUserDTO
import com.fashionflix.fashionflixapi.model.User
import com.fashionflix.fashionflixapi.schema.AuthResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(
    @Autowired val userRepository: UserRepository,
){

    fun findUserByEmail(email: String): User? {
         return userRepository.findUserByEmail(email)?.toUserDomain()
    }

    fun createUser(user: User): ResponseEntity<AuthResponse> {
        userRepository.createUser(user.toUserDTO())
        val token = UUID.randomUUID().toString()
        val authResponse = AuthResponse(token , "Signup Success")

        return ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED)
    }

    fun findUserById(id: String): User? {
        return userRepository.findUserById(id)?.toUserDomain()
    }

    fun loginUserHandler(email: String): User? {
        return userRepository.findUserByEmail(email)?.toUserDomain()
    }
}