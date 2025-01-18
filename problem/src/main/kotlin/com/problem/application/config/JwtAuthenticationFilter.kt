package com.problem.application.config

import com.problem.application.common.JwtTokenProvider
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter


@Component
class JwtAuthenticationFilter : OncePerRequestFilter() {
    private lateinit var jwtTokenProvider: JwtTokenProvider

    init {
        this.jwtTokenProvider = JwtTokenProvider()
    }


    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authorizationHeader = request.getHeader("Authorization")

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            val token = authorizationHeader.substring(7)
            if (jwtTokenProvider.validateToken(token)) {
                val tokenResult: Map<String, Any> = jwtTokenProvider.parseToken(token)

                val userDetails: UserDetails =
                    CustomUserDetails(CustomUserDto(tokenResult["userId"] as Long, tokenResult["role"] as String))

                if (userDetails != null) {
                    //UserDetsils, Password, Role -> 접근권한 인증 Token 생성
                    val usernamePasswordAuthenticationToken =
                        UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)

                    // 현재 Request의 Security Context에 접근권한 설정
                    SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
                }
            }
        }

        filterChain.doFilter(request, response)
    }


}
