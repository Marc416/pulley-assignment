package com.problem.domain.entity.history

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class ProblemTryHistory(
    val problemId: Long,
    val studentId: Long,
    val isCorrect: Boolean,
    val everCorrect: Boolean,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}