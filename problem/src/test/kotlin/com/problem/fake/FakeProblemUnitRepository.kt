package com.problem.fake

import com.problem.domain.entity.ProblemUnit
import com.problem.domain.repository.ProblemUnitRepository

class FakeProblemUnitRepository:ProblemUnitRepository {
    private val map = mutableMapOf<Long, ProblemUnit>()
    override fun save(problemUnit: ProblemUnit): ProblemUnit {
        map[problemUnit.id] = problemUnit
        return problemUnit
    }

    override fun findByUnitCodes(unitCodes: List<String>): List<ProblemUnit> {
        return map.filterValues { it.unitCode in unitCodes }.values.toList()
    }
}