package com.problem.domain.usecase.history

import com.problem.domain.entity.history.PieceTryHistory

interface PieceTryHistoryQueryUseCase {
    fun findByPieceIdAndStudentIds(pieceId: Long, studentIds: List<Long>): List<PieceTryHistory>
}