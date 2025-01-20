package com.problem.application.repository

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

    override fun findByUnitCodeInAndLevelInAndTypeIn(
        count: Int,
        unitCodeList: List<String>,
        levels: List<Int>,
        problemType: List<ProblemType>
    ): List<Problem> {
        return repository.findByUnitCodeInAndLevelInAndTypeIn(
            unitCodeList,
            levels,
            problemType,
            PageRequest.of(0, count)
        )
    }

    override fun findByIds(ids: List<Long>): List<Problem> {
        return repository.findByIds(ids)
    }

    override fun save(problem: Problem): Problem {
        return repository.save(problem)
    }
}

interface JpaProblemRepositoryImpl : JpaRepository<Problem, Long> {
    @Query("SELECT p FROM Problem p WHERE p.unitCode IN :unitCode AND p.type IN :type AND p.level IN :level  ORDER BY p.unitCode, p.type, p.level")
    fun findByUnitCodeInAndLevelInAndTypeIn(
        unitCode: List<String>,
        level: List<Int>,
        type: List<ProblemType>,
        pageable: Pageable
    ): List<Problem>

    @Query("SELECT p FROM Problem p WHERE p.id IN :ids")
    fun findByIds(ids: List<Long>): List<Problem>
}