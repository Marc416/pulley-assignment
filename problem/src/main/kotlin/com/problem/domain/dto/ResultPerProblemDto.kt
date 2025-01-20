package com.problem.domain.dto

data class ResultPerProblemDto (
    val problemId: Long,
    val correctRate:Int,
    val unitCode: String,
    val unitName:String,
)