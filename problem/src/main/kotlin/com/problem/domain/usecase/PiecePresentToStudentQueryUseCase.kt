package com.problem.domain.usecase

import com.problem.domain.entity.PiecePresentToStudent

interface PiecePresentToStudentQueryUseCase {
    fun findByTeacherIdAndPieceId(teacherId: Long, pieceId: Long): List<PiecePresentToStudent>
}