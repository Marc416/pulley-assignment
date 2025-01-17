package com.problem.application.common

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*


@Service
class JwtTokenProvider {

    fun generateToken(userId: String, role: String): String {
        val now = LocalDateTime.now()

        return JWT.create()
            .withSubject(userId)
            .withClaim("role", role)
            .withIssuedAt(Date())
            .sign(Algorithm.none())
    }

    fun parseToken(token: String): Map<String, Any> {
        val decodedJWT = JWT.decode(token)
        val userId = decodedJWT.getClaim("userId").asLong()// 사용자 아이디
        val role = decodedJWT.getClaim("role").asString() // 역할

        return mapOf(
            "userId" to userId,
            "role" to role,
        )
    }

    fun validateToken(token: String): Boolean {
        return try {
            JWT.decode(token)
            true
        } catch (e: Exception) {
            false
        }
    }
}