package com.problem.domain.usecase

import com.problem.domain.entity.Piece

interface PieceQueryUseCase {
    fun findPieceProblemsToStudent(studentId: Long, pieceId: Long): Piece
    fun findByTeacherIdAndPieceId(teacherId: Long, pieceId: Long): Piece
}