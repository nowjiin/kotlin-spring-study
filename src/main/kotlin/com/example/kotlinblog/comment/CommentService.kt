package com.example.kotlinblog.comment

import com.example.kotlinblog.post.PostEntity
import com.example.kotlinblog.post.PostRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CommentService(
    private val commentRepository: CommentRepository,
    private val postRepository: PostRepository,
) {

    fun createComment(commentDTO: CommentDTO): CommentDTO {
        val postEntity = postRepository.findById(commentDTO.postId!!)
            .orElseThrow { IllegalArgumentException("Post not found") }
        val commentEntity = commentDTO.toEntity(postEntity)
        val savedComment = commentRepository.save(commentEntity)
        return savedComment.toDTO()
    }

    fun getCommentsByPostId(postId: Long): List<CommentDTO> {
        return commentRepository.findByPostId(postId).map { it.toDTO() }
    }

    // Extension functions to convert between DTO and Entity
    private fun CommentDTO.toEntity(post: PostEntity) = CommentEntity(
        id = this.id,
        content = this.content,
        author = this.author,
        createdAt = this.createdAt ?: LocalDateTime.now(),
        post = post,
    )

    private fun CommentEntity.toDTO() = CommentDTO(
        id = this.id,
        content = this.content,
        author = this.author,
        createdAt = this.createdAt,
        postId = this.post?.id,
    )
}
