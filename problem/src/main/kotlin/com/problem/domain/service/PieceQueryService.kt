package com.problem.domain.service

import com.problem.application.common.httpresponse.CodeEnum
import com.problem.application.exception.ApplicationException
import com.problem.domain.entity.Piece
import com.problem.domain.repository.PiecePresentToStudentRepository
import com.problem.domain.repository.PieceRepository
import com.problem.domain.usecase.PieceQueryUseCase
import org.springframework.stereotype.Service

@Service
class PieceQueryService(
    val pieceRepository: PieceRepository,
    val piecePresentToStudentRepository: PiecePresentToStudentRepository,
) : PieceQueryUseCase {
    override fun findPieceProblemsToStudent(studentId: Long, pieceId: Long): Piece {
        val pieceId = findPieceId(studentId, pieceId)
        return findById(pieceId)

    }

    override fun findByTeacherIdAndPieceId(teacherId: Long, pieceId: Long): Piece {
        return pieceRepository.findByTeacherIdAndPieceId(teacherId, pieceId)
    }

    private fun findById(pieceId: Long): Piece {
        return pieceRepository.findById(pieceId)
    }

    private fun findPieceId(studentId: Long, pieceId: Long): Long {
        val presentedPiece = piecePresentToStudentRepository.findByPieceIdAndStudentIds(pieceId, listOf(studentId))
        if (presentedPiece.isEmpty()) {
            throw ApplicationException(code = CodeEnum.FRS_001, "Piece is not presented to student")
        }
        return presentedPiece.first().pieceId
    }
}