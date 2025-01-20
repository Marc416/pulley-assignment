package com.problem.application.repository

import com.problem.domain.entity.PiecePresentToStudent
import com.problem.domain.repository.PiecePresentToStudentRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class PiecePresentToStudentRepositoryImpl(
    private val repository: JpaPiecePresentToStudentRepositoryImpl
) : PiecePresentToStudentRepository {
    override fun findByPieceIdAndStudentIds(pieceId: Long, studentIds: List<Long>): List<PiecePresentToStudent> {
        return repository.findByPieceIdAndStudentIdIn(pieceId, studentIds)
    }

    @Transactional
    override fun saveAll(piecePresentToStudent: List<PiecePresentToStudent>): List<PiecePresentToStudent> {
        return repository.saveAll(piecePresentToStudent)
    }

    override fun findByTeacherIdAndPieceId(teacherId: Long, pieceId: Long): List<PiecePresentToStudent> {
        return repository.findByTeacherIdAndPieceId(teacherId, pieceId)
    }
}

interface JpaPiecePresentToStudentRepositoryImpl : JpaRepository<PiecePresentToStudent, Long> {
    @Query("SELECT p FROM PiecePresentToStudent p WHERE p.pieceId = :pieceId AND p.studentId IN :studentIds AND p.deletedAt IS NULL")
    fun findByPieceIdAndStudentIdIn(pieceId: Long, studentIds: List<Long>): List<PiecePresentToStudent>

    @Query("SELECT p FROM PiecePresentToStudent p WHERE p.teacherId = :teacherId AND p.pieceId = :pieceId AND p.deletedAt IS NULL")
    fun findByTeacherIdAndPieceId(teacherId: Long, pieceId: Long): List<PiecePresentToStudent>
}