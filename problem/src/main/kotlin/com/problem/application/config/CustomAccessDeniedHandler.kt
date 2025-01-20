package com.problem.application.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.problem.application.common.httpresponse.CodeEnum
import com.problem.application.controller.response.ApplicationExceptionResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component


@Component
class CustomAccessDeniedHandler : AccessDeniedHandler {
    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        accessDeniedException: AccessDeniedException
    ) {
        val errorResponse = ApplicationExceptionResponse(
            message = "Access Denied: You do not have the required role",
            code = CodeEnum.FRS_002,
            data = null
        )
        val jsonResponse = ObjectMapper().writeValueAsString(errorResponse)

        response.status = HttpStatus.BAD_REQUEST.value()
        response.contentType = "application/json"
        response.writer.write(jsonResponse)
        logger.error(accessDeniedException.stackTraceToString())
    }
}