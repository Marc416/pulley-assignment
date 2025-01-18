package com.problem.domain.usecase

import com.problem.domain.entity.ProblemDetail

interface ProblemDetailQueryUseCase {
    fun findProblemDetails(problemIds: List<Long>): List<ProblemDetail>
}