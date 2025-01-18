package com.problem.fake

import com.problem.domain.entity.ProblemDetail
import com.problem.domain.repository.ProblemDetailRepository

class FakeProblemDetailRepository: ProblemDetailRepository {
    private val map = mutableMapOf<Long, ProblemDetail>()
    override fun findByProblemIds(problemIds: List<Long>): List<ProblemDetail> {
        return map.filterKeys { it in problemIds }.values.toList()
    }

    override fun save(problemDetail: ProblemDetail): ProblemDetail {
        map[problemDetail.problemId] = problemDetail
        return problemDetail
    }


}