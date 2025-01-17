package com.problem.domain.service

import com.problem.domain.dto.problem.ProblemCondition
import com.problem.domain.dto.problem.ProblemDto
import com.problem.domain.repository.ProblemRepository
import com.problem.domain.usecase.ProblemQueryUseCase
import org.springframework.stereotype.Service

@Service
class ProblemQueryService(
    private val problemRepository: ProblemRepository
) : ProblemQueryUseCase {

    override fun findByCondition(problemCondition: ProblemCondition) :ProblemDto{
        return problemRepository.findProblemByCondition(problemCondition)
    }
}