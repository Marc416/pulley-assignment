package com.problem.application.config

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors

class CustomUserDetails(
    val user: CustomUserDto
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        val roles: MutableList<String> = ArrayList()
        roles.add("ROLE_" + user.role.toString())


        return roles.stream()
            .map { role: String? ->
                SimpleGrantedAuthority(
                    role
                )
            }
            .collect(Collectors.toList())
    }


    override fun getPassword(): String {
        return ""
    }

    override fun getUsername(): String {
        return user.userId.toString()
    }


}

data class CustomUserDto(
    val userId: Long,
    val role: String,
)