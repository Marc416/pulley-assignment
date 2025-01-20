package com.problem.fake

import com.problem.domain.entity.PiecePresentToStudent
import com.problem.domain.repository.PiecePresentToStudentRepository

class FakePiecePresentToStudentRepository : PiecePresentToStudentRepository {
    private val map = mutableMapOf<Long, PiecePresentToStudent>()
    override fun findByPieceIdAndStudentIds(pieceId: Long, studentIds: List<Long>): List<PiecePresentToStudent> {
        return map.values.filter { it.pieceId == pieceId && it.studentId in studentIds }
    }

    override fun saveAll(piecePresentToStudent: List<PiecePresentToStudent>): List<PiecePresentToStudent> {
        piecePresentToStudent.forEach { map[it.id] = it }
        return piecePresentToStudent
    }

    override fun findByTeacherIdAndPieceId(teacherId: Long, pieceId: Long): List<PiecePresentToStudent> {
        return map.values.filter { it.teacherId == teacherId && it.pieceId == pieceId }
    }


}