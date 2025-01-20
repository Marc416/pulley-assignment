package com.problem.application.controller.request

import jakarta.validation.Valid
import jakarta.validation.constraints.Size

data class CreatePieceRequest(
    val pieceTitle: String,
    @field:Valid @field:Size(max = 50, message = "problemListIds size must be less than 50")
    val problemListIds: List<Long>,
)