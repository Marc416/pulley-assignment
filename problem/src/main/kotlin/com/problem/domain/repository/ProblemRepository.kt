package com.problem.domain.repository

import com.problem.domain.dto.problem.ProblemType
import com.problem.domain.entity.Problem

interface ProblemRepository {
    fun findByUnitCodeInAndLevelInAndTypeIn(
        count: Int,
        unitCodeList: List<String>,
        levels: List<Int>,
        problemType: List<ProblemType>,
    ): List<Problem>
}