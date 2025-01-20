package com.problem.domain.entity

import com.problem.application.common.httpresponse.CodeEnum
import com.problem.application.config.converter.LongListConverter
import com.problem.application.exception.ApplicationException
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Piece(
    val title: String,
    @Convert(converter = LongListConverter::class)
    @Column(name = "problem_list")
    val problems: List<Long>,
    val teacherId: Long,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    init {
        if (problems.size > 50) {
            throw ApplicationException(CodeEnum.FRS_003, "The number of problems cannot exceed 50.")
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var updatedAt: LocalDateTime? = null
    var deletedAt: LocalDateTime? = null
}