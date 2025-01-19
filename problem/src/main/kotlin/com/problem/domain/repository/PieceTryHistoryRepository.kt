package com.problem.domain.repository

import com.problem.domain.entity.PieceTryHistory

interface PieceTryHistoryRepository {
    fun findByPieceIdAndStudentId(pieceId: Long, studentId: Long): PieceTryHistory?
    fun save(pieceTryHistory: PieceTryHistory): PieceTryHistory
}