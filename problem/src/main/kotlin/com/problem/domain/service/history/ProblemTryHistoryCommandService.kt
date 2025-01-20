package com.problem.domain.service.history

import com.problem.domain.dto.AnswerTryDto
import com.problem.domain.entity.history.ProblemTryHistory
import com.problem.domain.repository.history.ProblemTryHistoryRepository
import com.problem.domain.usecase.history.ProblemTryHistoryCommandUseCase
import org.springframework.stereotype.Service

@Service
class ProblemTryHistoryCommandService(
    private val problemTryHistoryRepository: ProblemTryHistoryRepository
) : ProblemTryHistoryCommandUseCase {
    override fun execute(studentAnswers: List<AnswerTryDto>): List<ProblemTryHistory> {
        val latestProblemTryHistories = problemTryHistoryRepository.findByProblemIdsAndStudentIds(
            studentAnswers.map { it.problemId },
            studentAnswers.map { it.studentId }
        )
        val latestProblemTryHistoriesMap = latestProblemTryHistories.associateBy { it.problemId }
        val problemTryHistories = studentAnswers.map { answerTryDto ->
            val latestProblemTryHistory = latestProblemTryHistoriesMap[answerTryDto.problemId]
            if (latestProblemTryHistory == null) {
                ProblemTryHistory(
                    problemId = answerTryDto.problemId,
                    studentId = answerTryDto.studentId,
                    isCorrect = answerTryDto.isCorrect,
                    everCorrect = answerTryDto.isCorrect,
                )
            } else {
                ProblemTryHistory(
                    problemId = answerTryDto.problemId,
                    studentId = answerTryDto.studentId,
                    isCorrect = answerTryDto.isCorrect,
                    everCorrect = latestProblemTryHistory.everCorrect || answerTryDto.isCorrect,
                )
            }
        }
        return problemTryHistoryRepository.saveAll(problemTryHistories)
    }

}