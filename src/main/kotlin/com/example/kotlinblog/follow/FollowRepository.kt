package com.example.kotlinblog.follow

import com.example.kotlinblog.user.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FollowRepository : JpaRepository<FollowEntity, Long> {
    fun findByFollowerAndFollowing(follower: UserEntity, following: UserEntity): FollowEntity?
    fun findAllByFollower(follower: UserEntity): List<FollowEntity>
}
