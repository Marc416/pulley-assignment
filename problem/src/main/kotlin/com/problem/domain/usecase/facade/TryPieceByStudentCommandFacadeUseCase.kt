package com.problem.domain.usecase.facade

import com.problem.application.controller.request.ProblemAnswer
import com.problem.domain.dto.problem.ProblemAnswerResult

interface TryPieceByStudentCommandFacadeUseCase {
    fun tryPiece(studentId: Long, pieceId: Long, studentAnswers: List<ProblemAnswer>): List<ProblemAnswerResult>
}