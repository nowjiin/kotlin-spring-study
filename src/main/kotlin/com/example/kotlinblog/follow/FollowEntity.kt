package com.example.kotlinblog.follow

import com.example.kotlinblog.user.UserEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "follow")
data class FollowEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "follower_id")
    val follower: UserEntity,

    @ManyToOne
    @JoinColumn(name = "following_id")
    val following: UserEntity,
)
