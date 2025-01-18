package com.problem.fake

import com.problem.application.common.httpresponse.CodeEnum
import com.problem.application.exception.ApplicationException
import com.problem.domain.entity.Piece
import com.problem.domain.repository.PieceRepository

class FakePieceRepository : PieceRepository {
    private val map = mutableMapOf<Long, Piece>()

    override fun save(piece: Piece): Piece {
        map[piece.id] = piece
        return piece
    }

    override fun findById(id: Long): Piece {
        return map[id] ?: throw ApplicationException(code = CodeEnum.FRS_001,"Piece not found")
    }

}