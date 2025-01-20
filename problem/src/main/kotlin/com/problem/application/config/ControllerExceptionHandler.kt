package com.problem.application.config

import com.problem.application.controller.response.ApplicationExceptionResponse
import com.problem.application.controller.response.ErrorResponse
import com.problem.application.exception.ApplicationException
import com.problem.application.exception.ErrorType
import jakarta.validation.ValidationException
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.stream.Collectors

val logger = KotlinLogging.logger {}

@RestControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler(ApplicationException::class)
    fun handleApplicationException(e: ApplicationException): ResponseEntity<ApplicationExceptionResponse> {
        logger.error { "Application Exception occurred. code=${e.code.name}, message=${e.message}" }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                ApplicationExceptionResponse(
                    message = e.message ?: "",
                    code = e.code,
                    data = e.data
                )
            )
    }

    @ExceptionHandler(ValidationException::class)
    fun handleValidationException(e: ValidationException): ResponseEntity<ErrorResponse> {
        logger.error { "Validation Exception occurred. message=${e.message}" }
        logger.error { e.stackTraceToString() }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    e.message ?: "알수없는 오류가 발생했습니다.",
                    ErrorType.INVALID_REQUEST
                )
            )
    }

    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun handleMissingServletRequestParameterException(e: MissingServletRequestParameterException): ResponseEntity<ErrorResponse> {
        logger.error { "MissingServletRequestParameter Exception occurred. parameterName=${e.parameterName}, message=${e.message}" }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    e.message,
                    ErrorType.INVALID_REQUEST
                )
            )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        logger.error { "MethodArgumentNotValidException Exception occurred. message=${e.message}" }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    createMessage(e) ?: "알수없는 오류가 발생했습니다.",
                    ErrorType.INVALID_REQUEST
                )
            )
    }

    private fun createMessage(e: MethodArgumentNotValidException): String? {
        if (e.fieldError != null && e.fieldError!!.defaultMessage != null) {
            return e.fieldError!!.defaultMessage
        }

        return e.fieldErrors.stream()
            .map { obj: FieldError -> obj.field }
            .collect(Collectors.joining(", ")) + " 값들이 정확하지 않습니다."
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ErrorResponse> {
        logger.error { "Exception occurred. message=${e.message}" }
        logger.error { e.stackTraceToString() }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ErrorResponse(
                    e.message ?: "알수없는 오류가 발생했습니다.",
                    ErrorType.UNKNOWN
                )
            )
    }

}