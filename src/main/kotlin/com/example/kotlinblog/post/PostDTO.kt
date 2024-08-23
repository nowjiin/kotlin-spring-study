package com.example.kotlinblog.post

import java.time.LocalDateTime

data class PostDTO(
    val id: Long? = null,
    val title: String = "",
    val content: String = "",
    val author: String = "",
    val createdAt: LocalDateTime? = null,
)
