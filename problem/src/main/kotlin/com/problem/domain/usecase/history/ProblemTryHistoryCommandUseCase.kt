package com.problem.domain.usecase.history

import com.problem.domain.dto.AnswerTryDto
import com.problem.domain.entity.history.ProblemTryHistory

interface ProblemTryHistoryCommandUseCase {
    fun execute(studentAnswers: List<AnswerTryDto>): List<ProblemTryHistory>
}