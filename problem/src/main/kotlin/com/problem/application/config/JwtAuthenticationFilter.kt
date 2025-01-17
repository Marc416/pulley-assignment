package com.problem.application.config

import com.problem.application.common.JwtTokenProvider
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.util.List


@Component
class JwtAuthenticationFilter : OncePerRequestFilter() {
    private lateinit var jwtTokenProvider: JwtTokenProvider

    init {
        this.jwtTokenProvider = JwtTokenProvider()
    }

//    @Throws(ServletException::class, IOException::class)
//    override fun doFilterInternal(
//        request: HttpServletRequest,
//        response: HttpServletResponse,
//        filterChain: FilterChain
//    ) {
//        val token = resolveToken(request)
//
//        if (token != null && validateToken(token)) {
//            val auth: Authentication = getAuthentication(token)
//            val userDetails: UserDetails = customUserDetailsService.loadUserByUsername(auth.principal as String)
//            SecurityContextHolder.getContext().authentication = auth
//        }
//
//        filterChain.doFilter(request, response)
//    }

//    override fun doFilterInternal(
//        request: HttpServletRequest,
//        response: HttpServletResponse?,
//        filterChain: FilterChain
//    ) {
//        val authorizationHeader = request.getHeader("Authorization")
//
//        //JWT가 헤더에 있는 경우
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            val token = authorizationHeader.substring(7)
//            //JWT 유효성 검증
//            if (jwtUtil.validateToken(token)) {
//                val userId: Long = jwtTokenProvider.getUserId(token)
//
//                //유저와 토큰 일치 시 userDetails 생성
//                val userDetails: UserDetails = CustomUserDetails(userId)
//
//                if (userDetails != null) {
//                    //UserDetsils, Password, Role -> 접근권한 인증 Token 생성
//                    val usernamePasswordAuthenticationToken =
//                        UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
//
//                    //현재 Request의 Security Context에 접근권한 설정
//                    SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
//                }
//            }
//        }
//
//        filterChain.doFilter(request, response) // 다음 필터로 넘기기
//    }
//
//    private fun resolveToken(request: HttpServletRequest): String? {
//        val bearerToken = request.getHeader("Authorization")
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7)
//        }
//        return null
//    }
//
//    private fun validateToken(token: String): Boolean {
//        // JWT 유효성 검증 로직 추가 (서명, 만료 시간 확인 등)
//        return true
//    }

    private fun getAuthentication(token: String): Authentication {
        // JWT에서 ID와 role 파싱
        val tokenResult = jwtTokenProvider.parseToken(token)
        val userId = tokenResult["userId"]
        val role = tokenResult["role"] as String

        val authorities = List.of<GrantedAuthority>(SimpleGrantedAuthority(role))
        return UsernamePasswordAuthenticationToken(userId, null, authorities)
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

                val userDetails: UserDetails = CustomUserDetails(CustomUserDto(tokenResult["userId"] as Long, tokenResult["role"] as String))

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
