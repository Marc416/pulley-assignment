package com.problem.domain.service

import com.problem.domain.entity.ProblemDetail
import com.problem.domain.repository.ProblemDetailRepository
import com.problem.domain.usecase.ProblemDetailQueryUseCase
import org.springframework.stereotype.Service

@Service
class ProblemDetailQueryService(
    private val problemDetailRepository: ProblemDetailRepository
) : ProblemDetailQueryUseCase {
    override fun findProblemDetails(problemIds: List<Long>): List<ProblemDetail> {
        return problemDetailRepository.findByProblemIds(problemIds)
    }
}