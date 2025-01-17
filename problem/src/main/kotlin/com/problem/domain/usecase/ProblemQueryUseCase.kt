package com.problem.domain.usecase

import com.problem.domain.dto.problem.ProblemCondition
import com.problem.domain.dto.problem.ProblemDto

interface ProblemQueryUseCase {
    fun findByCondition(problemCondition: ProblemCondition): ProblemDto
}