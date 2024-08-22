package com.example.kotlinblog.user

data class UserDTO(
    var id: String,
    var username: String? = null,
    var email: String? = null,
)
