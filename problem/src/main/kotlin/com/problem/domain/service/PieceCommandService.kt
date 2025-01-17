package com.problem.domain.service

import com.problem.domain.entity.Piece
import com.problem.domain.repository.PieceRepository
import org.springframework.stereotype.Service

@Service
class PieceCommandService(
    private val pieceRepository: PieceRepository
) {
    fun create(title:String, problemList:List<Long>, teacherId:Long):Piece {
        val piece = Piece(title, problemList, teacherId)
        return pieceRepository.save(piece)
    }
}