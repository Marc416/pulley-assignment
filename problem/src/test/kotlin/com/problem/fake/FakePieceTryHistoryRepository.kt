package com.problem.fake

import com.problem.domain.entity.history.PieceTryHistory
import com.problem.domain.repository.history.PieceTryHistoryRepository

class FakePieceTryHistoryRepository : PieceTryHistoryRepository {
    private val map = mutableMapOf<Long, PieceTryHistory>()
    override fun findByPieceIdAndStudentId(pieceId: Long, studentId: Long): PieceTryHistory? {
        return map.values.find { it.pieceId == pieceId && it.studentId == studentId }
    }

    override fun save(pieceTryHistory: PieceTryHistory): PieceTryHistory {
        map[pieceTryHistory.id] = pieceTryHistory
        return pieceTryHistory
    }

    override fun findByPieceIdAndStudentIds(pieceId: Long, studentIds: List<Long>): List<PieceTryHistory> {
        return map.values.filter { it.pieceId == pieceId && it.studentId in studentIds }
    }
}