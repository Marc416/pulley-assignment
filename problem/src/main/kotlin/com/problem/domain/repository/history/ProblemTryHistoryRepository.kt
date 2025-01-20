package com.problem.domain.repository.history

import com.problem.domain.entity.history.ProblemTryHistory

interface ProblemTryHistoryRepository {
    fun save(problemTryHistory: ProblemTryHistory): ProblemTryHistory
    fun saveAll(problemTryHistory: List<ProblemTryHistory>): List<ProblemTryHistory>
    fun findByProblemIdAndStudentId(problemId: Long, studentId: Long): ProblemTryHistory?
    fun findByProblemIdsAndStudentIds(problemIds: List<Long>, studentIds: List<Long>): List<ProblemTryHistory>
}