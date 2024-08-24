package com.example.kotlinblog.comment

import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<CommentEntity, Long> {
    fun findByPostId(postId: Long): List<CommentEntity>
}
