package com.problem.application.repository

import com.problem.domain.dto.problem.ProblemCondition
import com.problem.domain.dto.problem.ProblemDto
import com.problem.domain.dto.problem.ProblemType
import com.problem.domain.entity.Problem
import com.problem.domain.repository.ProblemRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
class ProblemRepositoryImpl(
    private val repository: JpaProblemRepositoryImpl
) : ProblemRepository {
    override fun findProblemByCondition(condition: ProblemCondition): ProblemDto {
        val result = condition.getProblemCountByLevel().map {
            repository.findByUnitCodeInAndLevelInAndTypeIn(
                condition.unitCodeList,
                it.key.levels,
                condition.problemType.getValue(),
                PageRequest.of(0, it.value)
            )
        }.flatten()
        return ProblemDto(result)
    }
}

interface JpaProblemRepositoryImpl : JpaRepository<Problem, Long> {
    @Query("SELECT p FROM Problem p WHERE p.unitCode IN :unitCode AND p.level IN :level AND p.type IN :type ORDER BY p.unitCode, p.type, p.level")
    fun findByUnitCodeInAndLevelInAndTypeIn(
        unitCode: List<String>,
        level: List<Int>,
        type: List<ProblemType>,
        pageable: Pageable
    ): List<Problem>
}