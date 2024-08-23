package com.example.kotlinblog.post

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class PostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String = "",
    val content: String = "",
    val author: String = "",
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
