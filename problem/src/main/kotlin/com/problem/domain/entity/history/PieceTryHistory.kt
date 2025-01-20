package com.problem.domain.entity.history

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class PieceTryHistory(
    val pieceId: Long,
    val studentId: Long,
    val score: Int,
    val maxScore: Int,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
}