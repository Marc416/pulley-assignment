package com.problem.fake

import com.problem.domain.entity.history.ProblemTryHistory
import com.problem.domain.repository.history.ProblemTryHistoryRepository

class FakeProblemTryHistoryRepository : ProblemTryHistoryRepository {
    private val map = mutableMapOf<Long, ProblemTryHistory>()
    override fun save(problemTryHistory: ProblemTryHistory): ProblemTryHistory {
        map[problemTryHistory.id] = problemTryHistory
        return problemTryHistory
    }

    override fun saveAll(problemTryHistory: List<ProblemTryHistory>): List<ProblemTryHistory> {
        problemTryHistory.forEach { save(it) }
        return problemTryHistory
    }

    override fun findByProblemIdAndStudentId(problemId: Long, studentId: Long): ProblemTryHistory? {
        return map.values.find { it.problemId == problemId && it.studentId == studentId }
    }

    override fun findByProblemIdsAndStudentIds(
        problemIds: List<Long>,
        studentIds: List<Long>
    ): List<ProblemTryHistory> {
        return map.values.filter { it.problemId in problemIds && it.studentId in studentIds }
    }
}