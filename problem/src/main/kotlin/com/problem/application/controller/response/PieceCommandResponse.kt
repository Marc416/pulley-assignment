package com.problem.application.controller.response

import com.problem.application.common.httpresponse.CodeEnum

data class PieceCommandResponse(
    val code: CodeEnum = CodeEnum.RS_000,
    val pieceId: Long
)
