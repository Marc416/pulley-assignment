package com.problem.application.controller

import com.problem.domain.dto.problem.ProblemCondition
import com.problem.domain.dto.problem.ProblemDto
import com.problem.domain.usecase.ProblemQueryUseCase
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/problem")
class ProblemQueryController(
    val problemQueryUseCase: ProblemQueryUseCase
) {
    @GetMapping("")
    fun findByCondition(
        @ModelAttribute @Valid condition: ProblemCondition,
    ): ProblemDto {
        return problemQueryUseCase.findByCondition(condition)
    }
}