package com.problem.domain.dto

data class AnswerTryDto(
    val problemId: Long, val studentId: Long, val isCorrect: Boolean
)
