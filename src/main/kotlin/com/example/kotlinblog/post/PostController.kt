package com.example.kotlinblog.post

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/posts")
class PostController(private val postService: PostService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPost(@RequestBody postDTO: PostDTO): PostDTO {
        return postService.createPost(postDTO)
    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Long): PostDTO? {
        return postService.getPostById(id)
    }

    @GetMapping
    fun getAllPosts(): List<PostDTO> {
        return postService.getAllPosts()
    }

    @GetMapping("/author/{author}")
    fun getPostsByAuthor(@PathVariable author: String): List<PostDTO> {
        return postService.getPostsByAuthor(author)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePostById(@PathVariable id: Long) {
        postService.deletePostById(id)
    }
}
