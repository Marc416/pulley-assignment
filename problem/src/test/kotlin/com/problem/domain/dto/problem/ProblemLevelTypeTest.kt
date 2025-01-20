package com.problem.domain.dto.problem

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class ProblemLevelTypeTest {
    @Test
    fun `Middle레벨의 문제 배분(LOW 25%, MIDDLE 50%, HIGH 25%)`() {
        // Arrange
        val requestQuestionCount = 10
        val result = ProblemLevelType.MIDDLE.getProblemCountByLevel(requestQuestionCount)
        // Action
        val lowProblemCount = result[ProblemLevelType.LOW] ?: throw Exception("LOW 문제가 없습니다.")
        val middleProblemCount = result[ProblemLevelType.MIDDLE] ?: throw Exception("MIDDLE 문제가 없습니다.")
        val highProblemCount = result[ProblemLevelType.HIGH] ?: throw Exception("HIGH 문제가 없습니다.")
        assertThat(lowProblemCount).isEqualTo(3)
        assertThat(middleProblemCount).isEqualTo(4)
        assertThat(highProblemCount).isEqualTo(3)
    }

    @Test
    fun `HIGH레벨의 문제 배분(LOW 20%, MIDDLE 30%, HIGH 50%)`() {
        // Arrange
        val requestQuestionCount = 10
        val result = ProblemLevelType.HIGH.getProblemCountByLevel(requestQuestionCount)
        // Action
        val lowProblemCount = result[ProblemLevelType.LOW] ?: throw Exception("LOW 문제가 없습니다.")
        val middleProblemCount = result[ProblemLevelType.MIDDLE] ?: throw Exception("MIDDLE 문제가 없습니다.")
        val highProblemCount = result[ProblemLevelType.HIGH] ?: throw Exception("HIGH 문제가 없습니다.")
        assertThat(lowProblemCount).isEqualTo(2)
        assertThat(middleProblemCount).isEqualTo(3)
        assertThat(highProblemCount).isEqualTo(5)
    }

    @Test
    fun `LOW레벨의 문제 배분(LOW 50%, MIDDLE 30%, HIGH 20%)`() {
        // Arrange
        val requestQuestionCount = 10
        val result = ProblemLevelType.LOW.getProblemCountByLevel(requestQuestionCount)
        // Action
        val lowProblemCount = result[ProblemLevelType.LOW] ?: throw Exception("LOW 문제가 없습니다.")
        val middleProblemCount = result[ProblemLevelType.MIDDLE] ?: throw Exception("MIDDLE 문제가 없습니다.")
        val highProblemCount = result[ProblemLevelType.HIGH] ?: throw Exception("HIGH 문제가 없습니다.")
        assertThat(lowProblemCount).isEqualTo(5)
        assertThat(middleProblemCount).isEqualTo(3)
        assertThat(highProblemCount).isEqualTo(2)
    }
}