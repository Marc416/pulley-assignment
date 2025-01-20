package com.problem.domain.usecase.history

import com.problem.domain.entity.history.ProblemTryHistory

interface ProblemTryHistoryCommandUseCase {
    fun execute(problemId: Long, studentId: Long, isCorrect: Boolean): ProblemTryHistory
}