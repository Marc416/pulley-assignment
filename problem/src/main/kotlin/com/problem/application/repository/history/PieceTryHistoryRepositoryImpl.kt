package com.problem.application.repository.history

import com.problem.domain.entity.history.PieceTryHistory
import com.problem.domain.repository.history.PieceTryHistoryRepository
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

    override fun findByPieceIdAndStudentIds(pieceId: Long, studentIds: List<Long>): List<PieceTryHistory> {
        return repository.findByPieceIdAndStudentIds(pieceId, studentIds)
    }
}

interface JpaPieceTryHistoryRepository : JpaRepository<PieceTryHistory, Long> {
    @Query("SELECT pth FROM PieceTryHistory pth WHERE pth.pieceId = :pieceId AND pth.studentId = :studentId ORDER BY pth.createdAt DESC LIMIT 1")
    fun findByPieceIdAndStudentIdLatest(pieceId: Long, studentId: Long): PieceTryHistory?

    @Query("SELECT pth FROM PieceTryHistory pth WHERE pth.pieceId = :pieceId AND pth.studentId IN :studentIds")
    fun findByPieceIdAndStudentIds(pieceId: Long, studentIds: List<Long>): List<PieceTryHistory>
}