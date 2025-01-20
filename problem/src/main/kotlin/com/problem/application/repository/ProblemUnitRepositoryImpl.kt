package com.problem.application.repository

import com.problem.domain.entity.ProblemUnit
import com.problem.domain.repository.ProblemUnitRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
class ProblemUnitRepositoryImpl(
    private val repository: JpaProblemUnitRepository
) : ProblemUnitRepository {
    override fun findByUnitCodes(unitCodes: List<String>): List<ProblemUnit> {
        return repository.findByUnitCodes(unitCodes)
    }
}

interface JpaProblemUnitRepository : JpaRepository<ProblemUnit, Long> {
    @Query("SELECT pu FROM ProblemUnit pu WHERE pu.unitCode IN :unitCodes")
    fun findByUnitCodes(unitCodes: List<String>): List<ProblemUnit>
}