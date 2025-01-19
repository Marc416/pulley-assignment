package com.problem.application.repository

import com.problem.domain.entity.PieceTryHistory
import com.problem.domain.repository.PieceTryHistoryRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
class PieceTryHistoryRepositoryImpl(
    private val repository: JpaPieceTryHistoryRepository
) : PieceTryHistoryRepository {
    override fun findByPieceIdAndStudentId(pieceId: Long, studentId: Long): PieceTryHistory? {
        return repository.findByPieceIdAndStudentIdLatest(pieceId, studentId)
    }

    override fun save(pieceTryHistory: PieceTryHistory): PieceTryHistory {
        return repository.save(pieceTryHistory)
    }
}

interface JpaPieceTryHistoryRepository : JpaRepository<PieceTryHistory, Long> {
    @Query("SELECT pth FROM PieceTryHistory pth WHERE pth.pieceId = :pieceId AND pth.studentId = :studentId ORDER BY pth.createdAt DESC LIMIT 1")
    fun findByPieceIdAndStudentIdLatest(pieceId: Long, studentId: Long): PieceTryHistory?
}