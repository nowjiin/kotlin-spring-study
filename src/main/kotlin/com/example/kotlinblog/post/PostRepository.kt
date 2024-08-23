package com.example.kotlinblog.post

import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<PostEntity, Long> {
    fun findByAuthor(author: String): List<PostEntity>
}
