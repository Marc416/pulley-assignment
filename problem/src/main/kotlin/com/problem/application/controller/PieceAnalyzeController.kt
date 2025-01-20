package com.problem.application.controller

import com.problem.application.common.httpresponse.HttpApiResponse
import com.problem.application.config.CustomUserDetails
import com.problem.application.controller.response.PieceAnalyzeResponse
import com.problem.domain.usecase.facade.PieceAnalyzeFacadeUseCase
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/piece")
class PieceAnalyzeController(
    private val pieceAnalyzeFacadeUseCase: PieceAnalyzeFacadeUseCase
) {
    @RequestMapping("/analyze")
    fun analyze(
        @AuthenticationPrincipal userDetails: CustomUserDetails,
        @RequestParam pieceId: Long
    ): HttpApiResponse<PieceAnalyzeResponse> {
        return HttpApiResponse.of(pieceAnalyzeFacadeUseCase.analyze(userDetails.user.userId, pieceId))
    }
}