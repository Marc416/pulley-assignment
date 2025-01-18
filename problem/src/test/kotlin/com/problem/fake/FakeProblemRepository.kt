package com.problem.fake

import com.problem.domain.dto.problem.ProblemType
import com.problem.domain.entity.Problem
import com.problem.domain.repository.ProblemRepository

class FakeProblemRepository : ProblemRepository {
    var map = mutableMapOf<Long, Problem>()

    override fun findByUnitCodeInAndLevelInAndTypeIn(
        count: Int,
        unitCodeList: List<String>,
        levels: List<Int>,
        problemType: List<ProblemType>
    ): List<Problem> {
        return map.values.filter { problem ->
            problem.unitCode in unitCodeList &&
                problem.level in levels &&
                problem.type in problemType
        }
    }

    override fun findByIds(ids: List<Long>): List<Problem> {
        return map.values.filter { it.id in ids }
    }

    override fun save(problem: Problem): Problem {
        val id = map.size.toLong() + 1
        map[id] = problem
        return problem
    }
}