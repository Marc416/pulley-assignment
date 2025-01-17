package com.problem.application.config

import com.problem.application.controller.response.ErrorResponse
import com.problem.application.exception.ErrorType
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

val logger = KotlinLogging.logger {}

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun handleMissingServletRequestParameterException(e: MissingServletRequestParameterException): ResponseEntity<ErrorResponse> {
        logger.error { "MissingServletRequestParameter Exception occurred. parameterName=${e.parameterName}, message=${e.message}" }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    ErrorType.INVALID_PARAMETER.description,
                    ErrorType.INVALID_PARAMETER
                )
            )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        logger.error { "MethodArgumentNotValidException Exception occurred. message=${e.message}" }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    ErrorType.INVALID_PARAMETER.description,
                    ErrorType.INVALID_PARAMETER
                )
            )
    }
}