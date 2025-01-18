package com.problem.domain.repository

import com.problem.domain.entity.PiecePresentToStudent

interface PiecePresentToStudentRepository {
    fun findByPieceIdAndStudentIds(pieceId:Long, studentIds:List<Long>):List<PiecePresentToStudent>
    fun saveAll(piecePresentToStudent: List<PiecePresentToStudent>): List<PiecePresentToStudent>
}