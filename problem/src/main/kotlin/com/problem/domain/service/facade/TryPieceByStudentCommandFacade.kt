package com.problem.domain.service.facade

import com.problem.application.controller.request.ProblemAnswer
import com.problem.domain.dto.problem.ProblemAnswerResult
import com.problem.domain.entity.Problem
import com.problem.domain.usecase.PieceQueryUseCase
import com.problem.domain.usecase.PieceTryHistoryCommandUseCase
import com.problem.domain.usecase.ProblemQueryUseCase
import com.problem.domain.usecase.facade.TryPieceByStudentCommandFacadeUseCase
import org.springframework.stereotype.Service

@Service
class TryPieceByStudentCommandFacade(
    private val pieceQueryUseCase: PieceQueryUseCase,
    private val problemQueryUseCase: ProblemQueryUseCase,
    private val pieceTryHistoryCommandUseCase: PieceTryHistoryCommandUseCase
) : TryPieceByStudentCommandFacadeUseCase {
    override fun tryPiece(
        studentId: Long,
        pieceId: Long,
        studentAnswers: List<ProblemAnswer>
    ): List<ProblemAnswerResult> {
        val piece = pieceQueryUseCase.findPieceProblemsToStudent(studentId, pieceId)

        val problemsAndAnswers = problemQueryUseCase.findByIds(piece.problems)
        val answerResults = getProblemAnswerResult(problemsAndAnswers, studentAnswers)
        pieceTryHistoryCommandUseCase.execute(
            pieceId = pieceId,
            studentId = studentId,
            score = answerResults.count { it.isCorrect }
        )
        return answerResults
    }

    private fun getProblemAnswerResult(
        problemsAndAnswers: List<Problem>,
        studentAnswers: List<ProblemAnswer>
    ): List<ProblemAnswerResult> {
        val studentAnswersMap = studentAnswers.associateBy { it.problemId }
        return problemsAndAnswers.map { problemAndAnswer ->
            val studentAnswer = studentAnswersMap[problemAndAnswer.id] ?: return@map ProblemAnswerResult(
                problemId = problemAndAnswer.id,
                isCorrect = false
            )
            if (studentAnswer.answer != problemAndAnswer.answer) {
                ProblemAnswerResult(
                    problemId = problemAndAnswer.id,
                    isCorrect = false
                )
            } else {
                ProblemAnswerResult(
                    problemId = problemAndAnswer.id,
                    isCorrect = true
                )
            }
        }
    }
}