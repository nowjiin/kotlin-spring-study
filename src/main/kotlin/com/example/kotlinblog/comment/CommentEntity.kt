package com.example.kotlinblog.comment

import com.example.kotlinblog.post.PostEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
data class CommentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val content: String = "",
    val author: String = "",
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val post: PostEntity? = null,
)
