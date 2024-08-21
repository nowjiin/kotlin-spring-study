package com.example.kotlinblog.user

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun registerUser(@RequestBody user: UserEntity): UserEntity {
        return userService.registerUser(user)
    }

    @GetMapping("/email/{email}")
    fun findUserByEmail(@PathVariable email: String): UserEntity? {
        return userService.findUserByEmail(email)
    }
}
