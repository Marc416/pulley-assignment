package com.problem.domain.entity

import com.problem.application.config.converter.LongListConverter
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    var updatedAt: LocalDateTime? = null
    var deletedAt: LocalDateTime? = null
}