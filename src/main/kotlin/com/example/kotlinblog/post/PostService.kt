package com.example.kotlinblog.post

import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PostService(private val postRepository: PostRepository) {

    fun createPost(postDTO: PostDTO): PostDTO {
        val postEntity = postDTO.toEntity()
        val savedPost = postRepository.save(postEntity)
        return savedPost.toDTO()
    }

    fun getPostById(id: Long): PostDTO? {
        return postRepository.findById(id).orElse(null)?.toDTO()
    }

    fun getAllPosts(): List<PostDTO> {
        return postRepository.findAll().map { it.toDTO() }
    }

    fun getPostsByAuthor(author: String): List<PostDTO> {
        return postRepository.findByAuthor(author).map { it.toDTO() }
    }

    fun deletePostById(id: Long) {
        postRepository.deleteById(id)
    }

    // Extension functions to convert between DTO and Entity
    private fun PostDTO.toEntity() = PostEntity(
        id = this.id,
        title = this.title,
        content = this.content,
        author = this.author,
        createdAt = this.createdAt ?: LocalDateTime.now(),
    )

    private fun PostEntity.toDTO() = PostDTO(
        id = this.id,
        title = this.title,
        content = this.content,
        author = this.author,
        createdAt = this.createdAt,
    )
}
