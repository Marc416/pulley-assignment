package com.problem.domain.service

import com.problem.application.exception.ApplicationException
import com.problem.domain.dto.problem.ProblemCondition
import com.problem.domain.dto.problem.ProblemLevelType
import com.problem.domain.dto.problem.ProblemType
import com.problem.domain.repository.ProblemRepository
import com.problem.domain.usecase.ProblemQueryUseCase
import com.problem.fake.FakeProblemRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class ProblemQueryServiceTest {

    private lateinit var problemRepository: ProblemRepository
    private lateinit var problemQueryUseCase: ProblemQueryUseCase

    @BeforeEach
    fun setUp() {
        this.problemRepository = FakeProblemRepository()
        this.problemQueryUseCase = ProblemQueryService(problemRepository)
    }

    @Test
    fun `해당하는 리소스를 조회할 수 없는경우`() {
        // Arrange
        val problemCondition = ProblemCondition(
            totalCount = 0,
            unitCodeList = listOf("1"),
            level = ProblemLevelType.MIDDLE,
            problemType = ProblemType.ALL
        )
        // Action, Assert
        Assertions.assertThatThrownBy { problemQueryUseCase.findByCondition(problemCondition) }
            .isInstanceOf(ApplicationException::class.java)
    }
}