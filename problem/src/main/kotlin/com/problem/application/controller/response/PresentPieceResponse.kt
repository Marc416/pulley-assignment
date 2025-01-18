package com.problem.application.controller.response

data class PresentPieceResponse(
    val receivedStudents: List<Long>,
    val existStudents: List<Long>
)
