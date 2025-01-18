package com.problem.domain.service.facade

import com.problem.application.controller.response.ProblemQueryResponse
import com.problem.domain.usecase.PieceQueryUseCase
import com.problem.domain.usecase.ProblemDetailQueryUseCase
import com.problem.domain.usecase.ProblemQueryUseCase
import com.problem.domain.usecase.facade.ProblemQueryByPieceFacadeUseCase
import org.springframework.stereotype.Service

@Service
class ProblemQueryByPieceFacade(
    private val pieceQueryUseCase: PieceQueryUseCase,
    private val problemQueryUseCase: ProblemQueryUseCase,
    private val problemDetailQueryUseCase: ProblemDetailQueryUseCase
) : ProblemQueryByPieceFacadeUseCase {
    override fun findProblemDetailByPieceId(studentId: Long, pieceId: Long): ProblemQueryResponse {
        val piece = pieceQueryUseCase.findPieceProblemsToStudent(studentId, pieceId)
        val problemIds = piece.problems
        val problems = problemQueryUseCase.findByIds(problemIds)
        val problemDetailsMap = problemDetailQueryUseCase.findProblemDetails(problemIds).associateBy { it.problemId }
        val contents = problems.map {
            ProblemQueryResponse.Problem(
                id = it.id,
                title = problemDetailsMap[it.id]?.title ?: "문제 제목이 없습니다.",
                type = it.type,
                selections = problemDetailsMap[it.id]?.options
            )
        }
        return ProblemQueryResponse(
            pieceId = piece.id,
            pieceTitle = piece.title,
            problems = contents.map {
                ProblemQueryResponse.Problem(
                    id = it.id,
                    title = it.title,
                    type = it.type,
                    selections = it.selections
                )
            }
        )
    }
}