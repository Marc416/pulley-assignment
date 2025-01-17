package com.problem.application.controller.response

import com.problem.application.common.httpresponse.CodeEnum

class ApplicationExceptionResponse(
    val message: String = "",
    val code: CodeEnum,
    val data: Map<String, Any>?
) {
}