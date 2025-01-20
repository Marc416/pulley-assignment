package com.problem.domain.service

import com.problem.domain.entity.PiecePresentToStudent
import com.problem.domain.repository.PiecePresentToStudentRepository
import com.problem.domain.usecase.PiecePresentToStudentQueryUseCase
import org.springframework.stereotype.Service

@Service
class PiecePresentToStudentQueryService(
    private val piecePresentToStudentRepository: PiecePresentToStudentRepository
): PiecePresentToStudentQueryUseCase {
    override fun findByTeacherIdAndPieceId(teacherId: Long, pieceId: Long): List<PiecePresentToStudent> {
        return piecePresentToStudentRepository.findByTeacherIdAndPieceId(teacherId, pieceId)
    }
}