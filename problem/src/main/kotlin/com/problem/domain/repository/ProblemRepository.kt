package com.problem.domain.repository

import com.problem.domain.dto.problem.ProblemCondition
import com.problem.domain.dto.problem.ProblemDto

interface ProblemRepository {
    fun findProblemByCondition(condition: ProblemCondition): ProblemDto
}