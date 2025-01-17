package com.problem.domain.entity

import com.problem.domain.dto.problem.ProblemType
import jakarta.persistence.*

@Entity
class Problem(
    @Column(name = "unit_code")
    val unitCode: String,
    val level: Int,
    @Enumerated(EnumType.STRING)
    val type: ProblemType,
    val answer: String,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    override fun toString(): String {
        return "Problem(unitCode='$unitCode', level=$level, type=$type, answer='$answer', id=$id)"
    }
}