package com.problem.domain.service.facade

import com.problem.application.controller.request.ProblemAnswer
import com.problem.domain.dto.problem.ProblemAnswerResult
import com.problem.domain.entity.Problem
import com.problem.domain.usecase.PieceQueryUseCase
import com.problem.domain.usecase.history.PieceTryHistoryCommandUseCase
import com.problem.domain.usecase.ProblemQueryUseCase
import com.problem.domain.usecase.history.ProblemTryHistoryCommandUseCase
import com.problem.domain.usecase.facade.TryPieceByStudentCommandFacadeUseCase
import org.springframework.stereotype.Service
import kotlin.math.ceil

@Service
class TryPieceByStudentCommandFacade(
    private val pieceQueryUseCase: PieceQueryUseCase,
    private val problemQueryUseCase: ProblemQueryUseCase,
    private val pieceTryHistoryCommandUseCase: PieceTryHistoryCommandUseCase,
    private val problemTryHistoryCommandUseCase: ProblemTryHistoryCommandUseCase
) : TryPieceByStudentCommandFacadeUseCase {
    override fun tryPiece(
        studentId: Long,
        pieceId: Long,
        studentAnswers: List<ProblemAnswer>
    ): List<ProblemAnswerResult> {
        val piece = pieceQueryUseCase.findPieceProblemsToStudent(studentId, pieceId)

        val problemsAndAnswers = problemQueryUseCase.findByIds(piece.problems)
        val answerResults = getProblemAnswerResult(problemsAndAnswers, studentAnswers)
        executePieceTryHistory(studentId, pieceId, getScore(answerResults))
        executeProblemTryHistory(studentId, answerResults)
        return answerResults
    }

    private fun executePieceTryHistory(studentId: Long, pieceId: Long, score: Int) {
        pieceTryHistoryCommandUseCase.execute(
            pieceId = pieceId,
            studentId = studentId,
            score = score
        )
    }

    private fun executeProblemTryHistory(studentId: Long, answerResults: List<ProblemAnswerResult>) {
        answerResults.forEach {
            problemTryHistoryCommandUseCase.execute(
                problemId = it.problemId,
                studentId = studentId,
                isCorrect = it.isCorrect
            )
        }
    }

    // 소수 첫째자리 올림
    private fun getScore(answerResults: List<ProblemAnswerResult>): Int {
        val percentage = answerResults.count { it.isCorrect }.toDouble() / answerResults.size * 100
        val roundedUpPercentage = ceil(percentage * 10) / 10
        return roundedUpPercentage.toInt().coerceAtMost(100)
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