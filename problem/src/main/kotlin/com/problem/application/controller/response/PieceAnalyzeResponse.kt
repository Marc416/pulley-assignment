package com.problem.application.controller.response

import com.problem.domain.dto.ResultPerProblemDto

data class PieceAnalyzeResponse(
    val pieceId: Long,
    val title: String,
    val students: List<Student>,
    val resultsPerStudents: List<ResultPerStudent>,
    val resultsPerProblems: List<ResultPerProblem>,
) {
    data class Student(
        val id: Long,
        val name: String,
    )

    data class ResultPerStudent(
        val studentId: Long,
        val correctRate: Int,
    )

    data class ResultPerProblem(
        val problemId: Long,
        val correctRate: Int,
        val unitCode: String,
        val unitName: String,
    ){
        companion object{
            fun of(resultPerProblemDto: ResultPerProblemDto): ResultPerProblem {
                return ResultPerProblem(
                    problemId = resultPerProblemDto.problemId,
                    correctRate = resultPerProblemDto.correctRate,
                    unitCode = resultPerProblemDto.unitCode,
                    unitName = resultPerProblemDto.unitName
                )
            }
        }
    }
}
