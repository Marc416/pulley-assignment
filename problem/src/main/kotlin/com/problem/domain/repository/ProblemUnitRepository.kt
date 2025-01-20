package com.problem.domain.repository

import com.problem.domain.entity.ProblemUnit

interface ProblemUnitRepository {
    fun save(problemUnit: ProblemUnit): ProblemUnit
    fun findByUnitCodes(unitCodes: List<String>): List<ProblemUnit>
}