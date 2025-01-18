package com.problem.domain.repository

import com.problem.domain.entity.ProblemDetail

interface ProblemDetailRepository {
    fun findByProblemIds(problemIds: List<Long>): List<ProblemDetail>
    fun save(problemDetail: ProblemDetail): ProblemDetail
}