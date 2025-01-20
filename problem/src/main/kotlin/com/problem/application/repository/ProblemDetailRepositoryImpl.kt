package com.problem.application.repository

import com.problem.domain.entity.ProblemDetail
import com.problem.domain.repository.ProblemDetailRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
class ProblemDetailRepositoryImpl(
    private val repository: JpaProblemDetailRepository
) : ProblemDetailRepository {
    override fun findByProblemIds(problemIds: List<Long>): List<ProblemDetail> {
        return repository.findByProblemIds(problemIds)
    }

    override fun save(problemDetail: ProblemDetail): ProblemDetail {
        return repository.save(problemDetail)
    }
}

interface JpaProblemDetailRepository : JpaRepository<ProblemDetail, Long> {
    @Query("SELECT p FROM ProblemDetail p WHERE p.problemId IN :problemIds")
    fun findByProblemIds(problemIds: List<Long>): List<ProblemDetail>
}