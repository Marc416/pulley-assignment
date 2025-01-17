package com.problem.fake

import com.problem.domain.entity.Piece
import com.problem.domain.repository.PieceRepository

class FakePieceRepository : PieceRepository {
    private val pieces = mutableMapOf<Long, Piece>()

    override fun save(piece: Piece): Piece {
        pieces[piece.id] = piece
        return piece
    }

}