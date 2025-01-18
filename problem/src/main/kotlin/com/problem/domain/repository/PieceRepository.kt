package com.problem.domain.repository

import com.problem.domain.entity.Piece

interface PieceRepository {
    fun save(piece: Piece): Piece
    fun findById(id: Long): Piece
}