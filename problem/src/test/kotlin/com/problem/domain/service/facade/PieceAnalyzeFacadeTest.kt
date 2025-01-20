package com.problem.domain.service.facade

import com.problem.domain.dto.problem.ProblemType
import com.problem.domain.entity.Piece
import com.problem.domain.entity.PiecePresentToStudent
import com.problem.domain.entity.Problem
import com.problem.domain.entity.ProblemUnit
import com.problem.domain.entity.history.PieceTryHistory
import com.problem.domain.entity.history.ProblemTryHistory
import com.problem.domain.repository.PiecePresentToStudentRepository
import com.problem.domain.repository.PieceRepository
import com.problem.domain.repository.ProblemRepository
import com.problem.domain.repository.ProblemUnitRepository
import com.problem.domain.repository.history.PieceTryHistoryRepository
import com.problem.domain.repository.history.ProblemTryHistoryRepository
import com.problem.domain.service.PiecePresentToStudentQueryService
import com.problem.domain.service.PieceQueryService
import com.problem.domain.service.ProblemQueryService
import com.problem.domain.service.history.PieceTryHistoryQueryService
import com.problem.domain.service.history.ProblemTryHistoryQueryService
import com.problem.domain.usecase.PiecePresentToStudentQueryUseCase
import com.problem.domain.usecase.PieceQueryUseCase
import com.problem.domain.usecase.ProblemQueryUseCase
import com.problem.domain.usecase.facade.PieceAnalyzeFacadeUseCase
import com.problem.domain.usecase.history.PieceTryHistoryQueryUseCase
import com.problem.domain.usecase.history.ProblemTryHistoryQueryUseCase
import com.problem.fake.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class PieceAnalyzeFacadeTest {
    private lateinit var pieceRepository: PieceRepository
    private lateinit var piecePresentToStudentRepository: PiecePresentToStudentRepository
    private lateinit var problemRepository: ProblemRepository
    private lateinit var pieceTryHistoryRepository: PieceTryHistoryRepository
    private lateinit var problemTryHistoryRepository: ProblemTryHistoryRepository
    private lateinit var problemUnitRepository: ProblemUnitRepository

    private lateinit var piecePresentToStudentQueryUseCase: PiecePresentToStudentQueryUseCase
    private lateinit var problemTryHistoryQueryUseCase: ProblemTryHistoryQueryUseCase
    private lateinit var pieceQueryUseCase: PieceQueryUseCase
    private lateinit var problemQueryUseCase: ProblemQueryUseCase
    private lateinit var pieceAnalyzeFacade: PieceAnalyzeFacadeUseCase
    private lateinit var pieceTryHistoryQueryUseCase: PieceTryHistoryQueryUseCase

    @BeforeEach
    fun setUp() {
        this.pieceRepository = FakePieceRepository()
        this.problemRepository = FakeProblemRepository()
        this.piecePresentToStudentRepository = FakePiecePresentToStudentRepository()
        this.pieceTryHistoryRepository = FakePieceTryHistoryRepository()
        this.problemTryHistoryRepository = FakeProblemTryHistoryRepository()
        this.problemUnitRepository = FakeProblemUnitRepository()

        this.pieceQueryUseCase = PieceQueryService(
            pieceRepository = pieceRepository,
            piecePresentToStudentRepository = piecePresentToStudentRepository
        )
        this.problemQueryUseCase = ProblemQueryService(
            problemRepository = problemRepository
        )
        this.pieceTryHistoryQueryUseCase = PieceTryHistoryQueryService(
            pieceTryHistoryRepository = pieceTryHistoryRepository,
        )
        this.problemTryHistoryQueryUseCase = ProblemTryHistoryQueryService(
            problemTryHistoryRepository = problemTryHistoryRepository,
            problemRepository = problemRepository,
            problemUnitRepository = problemUnitRepository

        )
        piecePresentToStudentQueryUseCase = PiecePresentToStudentQueryService(
            piecePresentToStudentRepository = piecePresentToStudentRepository
        )

        this.pieceAnalyzeFacade = PieceAnalyzeFacade(
            pieceQueryUseCase = pieceQueryUseCase,
            piecePresentToStudentQueryUseCase = piecePresentToStudentQueryUseCase,
            pieceTryHistoryQueryUseCase = pieceTryHistoryQueryUseCase,
            problemTryHistoryQueryUseCase = problemTryHistoryQueryUseCase
        )
    }

    @Test
    fun `시험지에 대한 통계자료를 조회할 수 있다`() {
        // Arrange
        val teacherId = 1L
        val studentId = 2L
        val problemUnitCode = "unitcode"
        val problemUnit = ProblemUnit(
            unitCode = problemUnitCode,
            name = "unitName"
        )
        val problem = Problem(
            unitCode = problemUnitCode,
            level = 1,
            type = ProblemType.SELECTION,
            answer = "1"
        )
        this.problemRepository.save(problem)
        this.problemUnitRepository.save(problemUnit)

        val newPiece = Piece(
            title = "title",
            problems = listOf(problem.id),
            teacherId = teacherId,
        )
        val piece = this.pieceRepository.save(newPiece)

        piecePresentToStudentRepository.saveAll(
            listOf(
                PiecePresentToStudent(
                    pieceId = piece.id,
                    studentId = studentId,
                    teacherId = teacherId,
                )
            )
        )
        val pieceTryHistory = PieceTryHistory(
            pieceId = piece.id,
            studentId = studentId,
            score = 100,
            maxScore = 100
        )
        this.pieceTryHistoryRepository.save(
            pieceTryHistory
        )
        this.problemTryHistoryRepository.save(
            ProblemTryHistory(
                problemId = problem.id,
                studentId = studentId,
                isCorrect = true,
                everCorrect = true,
            )
        )

        // Action
        val pieceAnalyzeResult = pieceAnalyzeFacade.analyze(teacherId, piece.id)
        // Assert
        val resultPerProblem = pieceAnalyzeResult.resultsPerProblems[0]
        assertThat(resultPerProblem.correctRate).isEqualTo(100)
    }
}