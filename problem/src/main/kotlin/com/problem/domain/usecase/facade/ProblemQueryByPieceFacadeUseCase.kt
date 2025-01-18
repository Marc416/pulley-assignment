package com.problem.domain.usecase.facade

import com.problem.application.controller.response.ProblemQueryResponse

interface ProblemQueryByPieceFacadeUseCase {
    fun findProblemDetailByPieceId(studentId: Long, pieceId: Long): ProblemQueryResponse
}