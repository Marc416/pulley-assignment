package com.problem.domain.usecase

import com.problem.domain.dto.problem.ProblemCondition
import com.problem.domain.dto.problem.ProblemDto
import com.problem.domain.entity.Problem

interface ProblemQueryUseCase {
    fun findByCondition(problemCondition: ProblemCondition): ProblemDto
    fun findByIds(ids: List<Long>): List<Problem>
}