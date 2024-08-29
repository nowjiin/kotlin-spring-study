package com.example.kotlinblog.follow

import com.example.kotlinblog.user.UserEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/follows")
class FollowController(
    private val followService: FollowService,
) {

    @PostMapping("/follow")
    fun followUser(
        @RequestParam followerId: Long,
        @RequestParam followingId: Long,
    ): ResponseEntity<String> {
        val result = followService.followUser(followerId, followingId)
        return ResponseEntity.ok(result)
    }

    @PostMapping("/unfollow")
    fun unfollowUser(
        @RequestParam followerId: Long,
        @RequestParam followingId: Long,
    ): ResponseEntity<String> {
        val result = followService.unfollowUser(followerId, followingId)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/followers/{userId}")
    fun getFollowers(@PathVariable userId: Long): ResponseEntity<List<UserEntity>> {
        val followers = followService.getFollowers(userId)
        return ResponseEntity.ok(followers)
    }
}
