package com.problem.domain.repository.history

import com.problem.domain.entity.history.PieceTryHistory

interface PieceTryHistoryRepository {
    fun findByPieceIdAndStudentId(pieceId: Long, studentId: Long): PieceTryHistory?
    fun save(pieceTryHistory: PieceTryHistory): PieceTryHistory
    fun findByPieceIdAndStudentIds(pieceId: Long, studentIds: List<Long>): List<PieceTryHistory>
}