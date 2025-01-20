package com.problem.domain.usecase.history

interface PieceTryHistoryCommandUseCase {
    fun execute(pieceId: Long, studentId: Long, score: Int)
}