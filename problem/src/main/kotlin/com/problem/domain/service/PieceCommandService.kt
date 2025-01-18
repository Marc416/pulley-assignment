package com.problem.domain.service

import com.problem.application.common.httpresponse.CodeEnum
import com.problem.application.controller.response.PresentPieceResponse
import com.problem.application.exception.ApplicationException
import com.problem.domain.entity.Piece
import com.problem.domain.entity.PiecePresentToStudent
import com.problem.domain.repository.PiecePresentToStudentRepository
import com.problem.domain.repository.PieceRepository
import org.springframework.stereotype.Service

@Service
class PieceCommandService(
    private val pieceRepository: PieceRepository,
    private val piecePresentToStudentRepository: PiecePresentToStudentRepository
) {
    fun create(title: String, problemList: List<Long>, teacherId: Long): Piece {
        val piece = Piece(title, problemList, teacherId)
        return pieceRepository.save(piece)
    }

    fun presentPieceToStudents(pieceId: Long, studentIds: List<Long>, teacherId: Long): PresentPieceResponse {
        throwExceptionIfPieceIsNotTeacherOwned(pieceId, teacherId)

        val existLog = piecePresentToStudentRepository.findByPieceIdAndStudentIds(pieceId, studentIds)
        val existStudentIds = existLog.map { it.studentId }
        val newStudents = studentIds - existStudentIds
        val newPresentPieceToStudents = newStudents.map { PiecePresentToStudent(pieceId, it, teacherId) }
        val receivedStudentsLog = piecePresentToStudentRepository.saveAll(newPresentPieceToStudents)
        val receivedStudentIds = receivedStudentsLog.map { it.studentId }
        return PresentPieceResponse(existStudents = existStudentIds, receivedStudents = receivedStudentIds)
    }

    private fun throwExceptionIfPieceIsNotTeacherOwned(pieceId: Long, teacherId: Long) {
        val piece = pieceRepository.findById(pieceId)
        if (piece.teacherId != teacherId) {
            throw ApplicationException(code = CodeEnum.FRS_001, "Piece is not owned by teacher")
        }
    }
}