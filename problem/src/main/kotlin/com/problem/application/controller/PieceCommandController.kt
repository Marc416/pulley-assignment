package com.problem.application.controller

import com.problem.application.common.httpresponse.HttpApiResponse
import com.problem.application.config.CustomUserDetails
import com.problem.application.controller.request.CreatePieceRequest
import com.problem.application.controller.request.ProblemAnswer
import com.problem.application.controller.response.PieceCommandResponse
import com.problem.application.controller.response.PresentPieceResponse
import com.problem.domain.dto.problem.ProblemAnswerResult
import com.problem.domain.service.PieceCommandService
import com.problem.domain.usecase.facade.TryPieceByStudentCommandFacadeUseCase
import jakarta.validation.Valid
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
    ): HttpApiResponse<PieceCommandResponse> {
        val piece = pieceCommandService.create(
            title = request.pieceTitle,
            problemList = request.problemListIds,
            teacherId = userDetails.user.userId
        )
        return HttpApiResponse.of(PieceCommandResponse(pieceId = piece.id))
    }

    @PostMapping("/{pieceId}")
    fun presentPieceToStudents(
        @AuthenticationPrincipal userDetails: CustomUserDetails,
        @PathVariable pieceId: Long,
        @RequestParam studentIds: List<Long>,
    ): HttpApiResponse<PresentPieceResponse> {
        return HttpApiResponse.of(
            pieceCommandService.presentPieceToStudents(
                pieceId = pieceId,
                studentIds = studentIds,
                teacherId = userDetails.user.userId
            )
        )
    }

    @PutMapping("/problems")
    fun tryPieceByStudent(
        @RequestParam pieceId: Long,
        @AuthenticationPrincipal userDetails: CustomUserDetails,
        @RequestBody studentAnswers: List<ProblemAnswer>
    ): HttpApiResponse<List<ProblemAnswerResult>> {
        return HttpApiResponse.of(
            tryPieceByStudentCommandFacadeUseCase.tryPiece(
                studentId = userDetails.user.userId,
                pieceId = pieceId,
                studentAnswers = studentAnswers
            )
        )
    }
}