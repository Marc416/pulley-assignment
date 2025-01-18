package com.problem.application.repository

import com.problem.domain.entity.PiecePresentToStudent
import com.problem.domain.repository.PiecePresentToStudentRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
class PiecePresentToStudentRepositoryImpl(
    private val repository: JpaPiecePresentToStudentRepositoryImpl
) : PiecePresentToStudentRepository {
    override fun findByPieceIdAndStudentIds(pieceId: Long, studentIds: List<Long>): List<PiecePresentToStudent> {
        return repository.findByPieceIdAndStudentIdIn(pieceId, studentIds)
    }

    override fun saveAll(piecePresentToStudent: List<PiecePresentToStudent>): List<PiecePresentToStudent> {
        return repository.saveAll(piecePresentToStudent)
    }
}

interface JpaPiecePresentToStudentRepositoryImpl : JpaRepository<PiecePresentToStudent, Long> {
    fun findByPieceIdAndStudentIdIn(pieceId: Long, studentIds: List<Long>): List<PiecePresentToStudent>
}