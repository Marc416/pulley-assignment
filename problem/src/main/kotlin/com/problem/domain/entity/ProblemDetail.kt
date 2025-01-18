package com.problem.domain.entity

import com.problem.application.config.converter.JsonToMapConverter
import jakarta.persistence.*

@Entity
class ProblemDetail(
    val problemId: Long,
    val title : String,
    @Convert(converter = JsonToMapConverter::class)
    val options: Map<String, String>? = null,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
}