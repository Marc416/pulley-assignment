package com.problem.application.controller.response

import com.problem.domain.dto.problem.ProblemType

data class ProblemQueryResponse(
    val pieceId: Long,
    val pieceTitle: String,
    val problems: List<Problem>
) {
    data class Problem(
        val id: Long,
        val title: String,
        val type: ProblemType,
        val selections: Map<String, String>? = null,
    )
}
