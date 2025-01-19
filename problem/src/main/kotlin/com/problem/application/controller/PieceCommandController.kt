package com.problem.application.controller

import com.problem.application.config.CustomUserDetails
import com.problem.application.controller.request.ProblemAnswer
import com.problem.application.controller.response.PieceCommandResponse
import com.problem.application.controller.response.PresentPieceResponse
import com.problem.domain.dto.problem.ProblemAnswerResult
import com.problem.domain.service.PieceCommandService
import com.problem.domain.usecase.facade.TryPieceByStudentCommandFacadeUseCase
import jakarta.validation.Valid
import jakarta.validation.constraints.Size
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/piece")
class PieceCommandController(
    private val pieceCommandService: PieceCommandService,
    private val tryPieceByStudentCommandFacadeUseCase: TryPieceByStudentCommandFacadeUseCase,
) {
    @PostMapping("")
    fun createPiece(
        @AuthenticationPrincipal userDetails: CustomUserDetails,
        @Valid @RequestBody request: CreatePieceRequest
    ): PieceCommandResponse {
        val piece = pieceCommandService.create(
            title = request.pieceTitle,
            problemList = request.problemListIds,
            teacherId = userDetails.user.userId
        )
        return PieceCommandResponse(pieceId = piece.id)
    }

    @PostMapping("/{pieceId}")
    fun presentPieceToStudents(
        @AuthenticationPrincipal userDetails: CustomUserDetails,
        @PathVariable pieceId: Long,
        @RequestParam studentIds: List<Long>,
    ): PresentPieceResponse {
        return pieceCommandService.presentPieceToStudents(
            pieceId = pieceId,
            studentIds = studentIds,
            teacherId = userDetails.user.userId
        )
    }

    @PutMapping("/problems")
    fun tryPieceByStudent(
        @RequestParam pieceId: Long,
        @AuthenticationPrincipal userDetails: CustomUserDetails,
        @RequestBody studentAnswers: List<ProblemAnswer>
    ): List<ProblemAnswerResult> {
        return tryPieceByStudentCommandFacadeUseCase.tryPiece(
            studentId = userDetails.user.userId,
            pieceId = pieceId,
            studentAnswers = studentAnswers
        )
    }
}

data class CreatePieceRequest(
    val pieceTitle: String,
    @field:Valid @field:Size(max = 50, message = "problemListIds size must be less than 50")
    val problemListIds: List<Long>,
)