package com.problem.domain.dto.problem

import kotlin.math.ceil

enum class ProblemLevelType(val description: String, val levels: List<Int>) {
    LOW("하", listOf(1)),
    MIDDLE("중", listOf(2, 3, 4)),
    HIGH("상", listOf(5));

    fun getProblemCountByLevel(count: Int): Map<ProblemLevelType, Int> {
        val predictedValue = getPredictedCountPerProblemLevel(count)
        if (predictedValue.values.sum() != count) {
            val diff = count - predictedValue.values.sum()
            predictedValue[MIDDLE] = predictedValue[MIDDLE]!! + diff
        }
        return predictedValue
    }

    private fun getPredictedCountPerProblemLevel(count: Int): MutableMap<ProblemLevelType, Int> {
        return when (this) {
            LOW -> return mutableMapOf(
                LOW to ceil(count * 0.2).toInt(),
                MIDDLE to ceil(count * 0.3).toInt(),
                HIGH to ceil(count * 0.5).toInt()
            )

            MIDDLE -> return mutableMapOf(
                LOW to ceil(count * 0.25).toInt(),
                MIDDLE to ceil(count * 0.5).toInt(),
                HIGH to ceil(count * 0.25).toInt()
            )

            HIGH -> return mutableMapOf(
                LOW to ceil(count * 0.5).toInt(),
                MIDDLE to ceil(count * 0.3).toInt(),
                HIGH to ceil(count * 0.2).toInt()
            )
        }
    }
}