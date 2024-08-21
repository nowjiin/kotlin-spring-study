package com.example.kotlinblog.user

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) {
    fun registerUser(user: UserEntity): UserEntity {
        // 이메일 중복 체크
        if (userRepository.findByEmail(user.email).isPresent) {
            throw IllegalArgumentException("Email already in use")
        }

        // 유저네임 중복 체크
        if (userRepository.findByUsername(user.username).isPresent) {
            throw IllegalArgumentException("Username already taken")
        }

        // 비밀번호 암호화
        val encryptedPassword = passwordEncoder.encode(user.password)
        val newUser = user.copy(password = encryptedPassword)

        // 유저 저장
        return userRepository.save(newUser)
    }

    fun findUserByEmail(email: String): UserEntity? {
        return userRepository.findByEmail(email).orElse(null)
    }
}
