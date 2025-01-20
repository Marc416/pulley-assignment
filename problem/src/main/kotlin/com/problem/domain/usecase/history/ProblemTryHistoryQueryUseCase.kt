package com.problem.domain.usecase.history

import com.problem.domain.dto.ResultPerProblemDto

interface ProblemTryHistoryQueryUseCase {
    fun findByProblemIdsAndStudentIds(problemIds: List<Long>, studentIds: List<Long>): List<ResultPerProblemDto>
}