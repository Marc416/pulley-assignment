package com.problem.application.controller.response

import com.problem.application.exception.ErrorType

class ErrorResponse(
    val errorMessage: String,
    val errorType: ErrorType
)