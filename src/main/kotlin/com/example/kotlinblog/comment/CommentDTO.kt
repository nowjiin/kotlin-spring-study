package com.example.kotlinblog.comment

import java.time.LocalDateTime

data class CommentDTO(
    val id: Long? = null,
    val content: String = "",
    val author: String = "",
    val createdAt: LocalDateTime? = null,
    val postId: Long? = null, // 댓글이 연결된 Post의 ID
)
