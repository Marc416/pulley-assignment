package com.problem.domain.service.history

import com.problem.application.common.httpresponse.CodeEnum
import com.problem.application.exception.ApplicationException
import com.problem.domain.dto.ResultPerProblemDto
import com.problem.domain.entity.Problem
import com.problem.domain.entity.ProblemUnit
import com.problem.domain.repository.ProblemRepository
import com.problem.domain.repository.ProblemUnitRepository
import com.problem.domain.repository.history.ProblemTryHistoryRepository
import com.problem.domain.usecase.history.ProblemTryHistoryQueryUseCase
import org.springframework.stereotype.Service

@Service
class ProblemTryHistoryQueryService(
    private val problemTryHistoryRepository: ProblemTryHistoryRepository,
    private val problemRepository: ProblemRepository,
    private val problemUnitRepository: ProblemUnitRepository
) : ProblemTryHistoryQueryUseCase {
    override fun findByProblemIdsAndStudentIds(
        problemIds: List<Long>,
        studentIds: List<Long>
    ): List<ResultPerProblemDto> {
        val problemTryHistories = problemTryHistoryRepository.findByProblemIdsAndStudentIds(problemIds, studentIds)
        val problemTryHistoriesMap = problemTryHistories.groupBy { it.problemId }
        val problems = problemRepository.findByIds(problemIds)
        val problemIdToProblemUnitMap = getProblemIdToProblemUnitMap(problems)
        return problems.map {
            val correctCount = problemTryHistoriesMap[it.id]?.count { problemTry -> problemTry.everCorrect } ?: 0
            val correctRate = getCorrectRate(correctCount, studentIds)
            val unitDetail =
                problemIdToProblemUnitMap[it.id] ?: throw ApplicationException(CodeEnum.FRS_001, "존재하지 않는 Unit입니다")
            ResultPerProblemDto(
                problemId = it.id,
                correctRate = correctRate,
                unitCode = unitDetail.unitCode,
                unitName = unitDetail.name
            )
        }
    }

    private fun getProblemIdToProblemUnitMap(problems: List<Problem>): Map<Long, ProblemUnit> {
        val unitCodes = problems.map { it.unitCode }.distinct()
        val unitCodesMap = problemUnitRepository.findByUnitCodes(unitCodes).associate { it.unitCode to it }
        return problems.associate {
            val unitCode =
                unitCodesMap[it.unitCode] ?: throw ApplicationException(CodeEnum.FRS_001, "존재하지 않는 Unit입니다")
            it.id to unitCode
        }
    }

    // 소수 첫째자리에서 올림
    private fun getCorrectRate(correctCount: Int, studentIds: List<Long>): Int {
        val result = Math.round((correctCount.toDouble() / studentIds.size * 100) * 10) / 10.0
        return result.toInt()
    }
}