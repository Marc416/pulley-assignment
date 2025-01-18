package com.problem.domain.service

import com.problem.application.common.httpresponse.CodeEnum
import com.problem.application.exception.ApplicationException
import com.problem.domain.dto.problem.ProblemCondition
import com.problem.domain.dto.problem.ProblemDto
import com.problem.domain.entity.Problem
import com.problem.domain.repository.ProblemRepository
import com.problem.domain.usecase.ProblemQueryUseCase
import org.springframework.stereotype.Service

@Service
class ProblemQueryService(
    private val problemRepository: ProblemRepository
) : ProblemQueryUseCase {

    override fun findByCondition(problemCondition: ProblemCondition): ProblemDto {
        val result = problemCondition.getProblemCountByLevel()
            .map {
                problemRepository.findByUnitCodeInAndLevelInAndTypeIn(
                    it.value,
                    problemCondition.unitCodeList,
                    it.key.levels,
                    problemCondition.problemType.getValue(),
                )
            }.flatten()
        if (result.isEmpty()) {
            throw ApplicationException(CodeEnum.FRS_001, CodeEnum.FRS_001.description)
        }
        return ProblemDto(result)
    }

    override fun findByIds(ids: List<Long>): List<Problem> {
        return problemRepository.findByIds(ids)
    }

}