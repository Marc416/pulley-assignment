package com.problem.domain.service.history

import com.problem.domain.entity.history.PieceTryHistory
import com.problem.domain.repository.history.PieceTryHistoryRepository
import com.problem.domain.usecase.history.PieceTryHistoryCommandUseCase
import org.springframework.stereotype.Service
import kotlin.math.max

@Service
class PieceTryHistoryCommandService(
    private val pieceTryHistoryRepository: PieceTryHistoryRepository
) : PieceTryHistoryCommandUseCase {
    override fun execute(pieceId: Long, studentId: Long, score: Int) {
        val latestHistory = pieceTryHistoryRepository.findByPieceIdAndStudentId(pieceId, studentId)
        if (latestHistory == null) {
            pieceTryHistoryRepository.save(
                PieceTryHistory(
                    pieceId = pieceId,
                    studentId = studentId,
                    score = score,
                    maxScore = score
                )
            )
        } else {
            val maxScore = max(latestHistory.maxScore, score)
            pieceTryHistoryRepository.save(
                PieceTryHistory(
                    pieceId = pieceId,
                    studentId = studentId,
                    score = score,
                    maxScore = maxScore
                )
            )
        }
    }
}