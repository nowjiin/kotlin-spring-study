package com.example.kotlinblog.comment

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/comments")
class CommentController(private val commentService: CommentService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createComment(@RequestBody commentDTO: CommentDTO): CommentDTO {
        return commentService.createComment(commentDTO)
    }

    @GetMapping("/post/{postId}")
    fun getCommentsByPostId(@PathVariable postId: Long): List<CommentDTO> {
        return commentService.getCommentsByPostId(postId)
    }
}
