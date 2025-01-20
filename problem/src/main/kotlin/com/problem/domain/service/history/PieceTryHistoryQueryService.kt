package com.problem.domain.service.history

import com.problem.domain.entity.history.PieceTryHistory
import com.problem.domain.repository.history.PieceTryHistoryRepository
import com.problem.domain.usecase.history.PieceTryHistoryQueryUseCase
import org.springframework.stereotype.Service

@Service
class PieceTryHistoryQueryService(
    private val pieceTryHistoryRepository: PieceTryHistoryRepository
) : PieceTryHistoryQueryUseCase {
    override fun findByPieceIdAndStudentIds(pieceId: Long, studentIds: List<Long>): List<PieceTryHistory> {
        return pieceTryHistoryRepository.findByPieceIdAndStudentIds(pieceId, studentIds)
    }
}