package com.problem.domain.dto.problem

data class ProblemCondition(
    val totalCount: Int,
    val unitCodeList: List<String>,
    val level: ProblemLevelType,
    val problemType: ProblemType,
){
    fun getProblemCountByLevel(): Map<ProblemLevelType, Int> {
        return level.getProblemCountByLevel(totalCount)
    }
}