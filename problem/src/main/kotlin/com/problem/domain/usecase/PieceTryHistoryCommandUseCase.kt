package com.problem.domain.usecase

interface PieceTryHistoryCommandUseCase {
    fun execute(pieceId: Long, studentId: Long, score: Int)
}