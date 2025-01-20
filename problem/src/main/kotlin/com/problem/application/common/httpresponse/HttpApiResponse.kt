package com.problem.application.common.httpresponse

data class HttpApiResponse<T>(
    val code: CodeEnum,
    val message: String? = null,
    val data: T? = null

) {

    companion object {
        fun <T> of(data: T): HttpApiResponse<T> {
            return HttpApiResponse(
                code = CodeEnum.RS_000,
                data = data
            )
        }

        fun fromExceptionMessage(message: String, code: CodeEnum): HttpApiResponse<*> {
            return HttpApiResponse(
                code = code,
                message = message,
                data = null
            )
        }

        fun fromExceptionMessage(message: String, code: CodeEnum, data: Map<String, Any>): HttpApiResponse<*> {
            return HttpApiResponse(
                code = code,
                message = message,
                data = data
            )
        }

    }
}