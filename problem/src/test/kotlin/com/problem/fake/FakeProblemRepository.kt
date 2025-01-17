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
}