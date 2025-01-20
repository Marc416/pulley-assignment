package com.problem.application.repository.history

import com.problem.domain.entity.history.ProblemTryHistory
import com.problem.domain.repository.history.ProblemTryHistoryRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
class ProblemTryHistoryRepositoryImpl(
    private val repository: JpaProblemTryHistoryRepository
) : ProblemTryHistoryRepository {
    override fun save(problemTryHistory: ProblemTryHistory): ProblemTryHistory {
        return repository.save(problemTryHistory)
    }

    override fun findByProblemIdAndStudentId(problemId: Long, studentId: Long): ProblemTryHistory? {
        return repository.findByProblemIdAndStudentId(problemId, studentId)
    }

    override fun findByProblemIdsAndStudentIds(
        problemIds: List<Long>,
        studentIds: List<Long>
    ): List<ProblemTryHistory> {
        return repository.findByProblemIdsAndStudentIds(problemIds, studentIds)
    }
}

interface JpaProblemTryHistoryRepository : JpaRepository<ProblemTryHistory, Long> {
    @Query("SELECT pth FROM ProblemTryHistory pth WHERE pth.problemId = :problemId AND pth.studentId = :studentId ORDER BY pth.createdAt DESC LIMIT 1")
    fun findByProblemIdAndStudentId(problemId: Long, studentId: Long): ProblemTryHistory?

    @Query(
        """
        SELECT pth 
        FROM ProblemTryHistory pth 
        WHERE pth.problemId IN :problemIds 
          AND pth.studentId IN :studentIds
          AND pth.createdAt = (
              SELECT MAX(subPth.createdAt)
              FROM ProblemTryHistory subPth 
              WHERE subPth.problemId = pth.problemId 
                AND subPth.studentId = pth.studentId
          )
        """
    )
    fun findByProblemIdsAndStudentIds(problemIds: List<Long>, studentIds: List<Long>): List<ProblemTryHistory>
}