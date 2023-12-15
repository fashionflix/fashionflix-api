package com.fashionflix.fashionflixapi.controller


import com.fashionflix.fashionflixapi.model.User
import com.fashionflix.fashionflixapi.schema.AuthResponse
import com.fashionflix.fashionflixapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    @Autowired val userService: UserService
) {

    @PostMapping("/signup")
    fun createUserHandler(@RequestBody user: User): ResponseEntity<AuthResponse> {
        return userService.createUser(user)
    }

    @GetMapping("/login/{email}")
    fun loginUserHandler(@PathVariable email: String): ResponseEntity<User?> {
        return ResponseEntity(userService.findUserByEmail(email), HttpStatus.NOT_FOUND )
    }
}