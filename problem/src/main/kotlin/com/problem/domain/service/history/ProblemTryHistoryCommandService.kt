package com.problem.domain.service.history

import com.problem.domain.entity.history.ProblemTryHistory
import com.problem.domain.repository.history.ProblemTryHistoryRepository
import com.problem.domain.usecase.history.ProblemTryHistoryCommandUseCase
import org.springframework.stereotype.Service

@Service
class ProblemTryHistoryCommandService(
    private val problemTryHistoryRepository: ProblemTryHistoryRepository
) : ProblemTryHistoryCommandUseCase {
    override fun execute(problemId: Long, studentId: Long, isCorrect: Boolean): ProblemTryHistory {
        val latestProblemTryHistory = problemTryHistoryRepository.findByProblemIdAndStudentId(problemId, studentId)
        val newHistory = if (latestProblemTryHistory == null) {
            ProblemTryHistory(
                problemId = problemId,
                studentId = studentId,
                isCorrect = isCorrect,
                everCorrect = isCorrect,
            )
        } else {
            ProblemTryHistory(
                problemId = problemId,
                studentId = studentId,
                isCorrect = isCorrect,
                everCorrect = latestProblemTryHistory.everCorrect || isCorrect,
            )
        }
        return problemTryHistoryRepository.save(newHistory)
    }

}