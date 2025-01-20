package com.problem.application.controller

import com.problem.application.common.httpresponse.HttpApiResponse
import com.problem.application.config.CustomUserDetails
import com.problem.application.controller.response.ProblemQueryResponse
import com.problem.domain.service.facade.ProblemQueryByPieceFacade
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/piece")
class PieceQueryController(
    private val problemQueryByPieceFacade: ProblemQueryByPieceFacade
) {
    @GetMapping("/problems")
    fun findProblems(
        @RequestParam pieceId: Long,
        @AuthenticationPrincipal userDetails: CustomUserDetails,
    ): HttpApiResponse<ProblemQueryResponse> {
        return HttpApiResponse.of(
            problemQueryByPieceFacade.findProblemDetailByPieceId(
                userDetails.user.userId,
                pieceId
            )
        )
    }
}