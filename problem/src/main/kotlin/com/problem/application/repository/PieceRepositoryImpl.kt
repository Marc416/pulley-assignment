package com.problem.application.repository

import com.problem.application.common.httpresponse.CodeEnum
import com.problem.application.exception.ApplicationException
import com.problem.domain.entity.Piece
import com.problem.domain.repository.PieceRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
class PieceRepositoryImpl(
    private val repository: JpaPieceRepositoryImpl
) : PieceRepository {
    override fun save(piece: Piece): Piece {
        return repository.save(piece)
    }

    override fun findById(id: Long): Piece {
        return repository.findById(id).orElseThrow { ApplicationException(code = CodeEnum.FRS_001, "Piece not found") }
    }
}

interface JpaPieceRepositoryImpl : JpaRepository<Piece, Long> {
}