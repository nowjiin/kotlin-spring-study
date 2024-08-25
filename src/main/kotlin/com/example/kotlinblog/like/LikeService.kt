package com.example.kotlinblog.like

import com.example.kotlinblog.post.PostEntity
import com.example.kotlinblog.user.UserEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LikeService(
    private val likeRepository: LikeRepository,
) {

    @Transactional
    fun likePost(post: PostEntity, user: UserEntity) {
        if (likeRepository.findByPostIdAndUserId(post.id!!, user.id!!) == null) {
            val like = LikeEntity(post = post, user = user)
            likeRepository.save(like)
        }
    }

    @Transactional
    fun unlikePost(post: PostEntity, user: UserEntity) {
        likeRepository.deleteByPostIdAndUserId(post.id!!, user.id!!)
    }

    fun countLikes(post: PostEntity): Int {
        return likeRepository.countByPostId(post.id!!)
    }
}
