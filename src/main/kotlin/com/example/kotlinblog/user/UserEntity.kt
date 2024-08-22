package com.example.kotlinblog.user

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class UserEntity(
    @Id
    var id: String? = null,
    var username: String = "",
    var email: String = "",
    var password: String = "",
)
