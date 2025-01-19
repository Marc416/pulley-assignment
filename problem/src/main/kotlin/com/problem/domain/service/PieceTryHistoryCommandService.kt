package com.problem.domain.service

import com.problem.domain.entity.PieceTryHistory
import com.problem.domain.repository.PieceTryHistoryRepository
import com.problem.domain.usecase.PieceTryHistoryCommandUseCase
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