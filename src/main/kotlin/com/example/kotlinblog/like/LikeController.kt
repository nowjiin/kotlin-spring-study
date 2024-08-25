package com.example.kotlinblog.like

import com.example.kotlinblog.post.PostRepository
import com.example.kotlinblog.user.UserEntity
import com.example.kotlinblog.user.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/likes")
class LikeController(
    private val likeService: LikeService,
    private val postRepository: PostRepository,
    private val userRepository: UserRepository,
) {

    @PostMapping("/{postId}")
    fun likePost(@PathVariable postId: Long, @AuthenticationPrincipal user: UserEntity): ResponseEntity<String> {
        val post = postRepository.findById(postId).orElseThrow { RuntimeException("Post not found") }
        likeService.likePost(post, user)
        return ResponseEntity.ok("Liked the post")
    }

    @DeleteMapping("/{postId}")
    fun unlikePost(@PathVariable postId: Long, @AuthenticationPrincipal user: UserEntity): ResponseEntity<String> {
        val post = postRepository.findById(postId).orElseThrow { RuntimeException("Post not found") }
        likeService.unlikePost(post, user)
        return ResponseEntity.ok("Unliked the post")
    }

    @GetMapping("/{postId}/count")
    fun getLikeCount(@PathVariable postId: Long): ResponseEntity<Int> {
        val post = postRepository.findById(postId).orElseThrow { RuntimeException("Post not found") }
        val likeCount = likeService.countLikes(post)
        return ResponseEntity.ok(likeCount)
    }
}
