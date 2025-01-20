package com.problem.domain.usecase.facade

import com.problem.application.controller.response.PieceAnalyzeResponse

interface PieceAnalyzeFacadeUseCase {
    fun analyze(teacherId: Long, pieceId: Long): PieceAnalyzeResponse
}