package com.example.kotlinblog.follow

import com.example.kotlinblog.user.UserEntity
import com.example.kotlinblog.user.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FollowService(
    private val followRepository: FollowRepository,
    private val userRepository: UserRepository,
) {

    @Transactional
    fun followUser(followerId: Long, followingId: Long): String {
        val follower = userRepository.findById(followerId).orElseThrow { Exception("Follower not found") }
        val following = userRepository.findById(followingId).orElseThrow { Exception("Following user not found") }

        if (followRepository.findByFollowerAndFollowing(follower, following) != null) {
            return "Already following"
        }

        followRepository.save(FollowEntity(follower = follower, following = following))
        return "Followed successfully"
    }

    @Transactional
    fun unfollowUser(followerId: Long, followingId: Long): String {
        val follower = userRepository.findById(followerId).orElseThrow { Exception("Follower not found") }
        val following = userRepository.findById(followingId).orElseThrow { Exception("Following user not found") }

        val follow = followRepository.findByFollowerAndFollowing(follower, following)
            ?: return "Not following"

        followRepository.delete(follow)
        return "Unfollowed successfully"
    }

    fun getFollowers(userId: Long): List<UserEntity> {
        val user = userRepository.findById(userId).orElseThrow { Exception("User not found") }
        return followRepository.findAllByFollower(user).map { it.following }
    }
}
