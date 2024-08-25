package com.example.kotlinblog.like

import org.springframework.data.jpa.repository.JpaRepository

interface LikeRepository : JpaRepository<LikeEntity, Long> {
    fun findByPostIdAndUserId(postId: Long, userId: String): LikeEntity?
    fun countByPostId(postId: Long): Int
    fun deleteByPostIdAndUserId(postId: Long, userId: String)
}
