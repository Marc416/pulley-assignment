package com.problem.domain.service.facade

import com.problem.application.controller.request.ProblemAnswer
import com.problem.domain.dto.problem.ProblemType
import com.problem.domain.entity.Piece
import com.problem.domain.entity.PiecePresentToStudent
import com.problem.domain.entity.Problem
import com.problem.domain.entity.history.ProblemTryHistory
import com.problem.domain.repository.PiecePresentToStudentRepository
import com.problem.domain.repository.PieceRepository
import com.problem.domain.repository.ProblemRepository
import com.problem.domain.service.PieceQueryService
import com.problem.domain.service.ProblemQueryService
import com.problem.domain.usecase.PieceQueryUseCase
import com.problem.domain.usecase.history.PieceTryHistoryCommandUseCase
import com.problem.domain.usecase.ProblemQueryUseCase
import com.problem.domain.usecase.facade.TryPieceByStudentCommandFacadeUseCase
import com.problem.domain.usecase.history.ProblemTryHistoryCommandUseCase
import com.problem.fake.FakePiecePresentToStudentRepository
import com.problem.fake.FakePieceRepository
import com.problem.fake.FakeProblemRepository
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class TryPieceByStudentCommandFacadeTest {

    private lateinit var pieceRepository: PieceRepository
    private lateinit var piecePresentToStudentRepository: PiecePresentToStudentRepository
    private lateinit var problemRepository: ProblemRepository

    private lateinit var tryPieceByStudentCommandFacade: TryPieceByStudentCommandFacadeUseCase
    private lateinit var pieceQueryUseCase: PieceQueryUseCase
    private lateinit var problemQueryUseCase: ProblemQueryUseCase

    @BeforeEach
    fun setUp() {
        this.pieceRepository = FakePieceRepository()
        this.problemRepository = FakeProblemRepository()
        this.piecePresentToStudentRepository = FakePiecePresentToStudentRepository()
        this.pieceQueryUseCase = PieceQueryService(
            pieceRepository = pieceRepository,
            piecePresentToStudentRepository = piecePresentToStudentRepository
        )
        this.problemQueryUseCase = ProblemQueryService(
            problemRepository = problemRepository
        )

        val pieceTryHistoryCommandUseCase = mockk<PieceTryHistoryCommandUseCase>()
        every { pieceTryHistoryCommandUseCase.execute(any(), any(), any()) } returns Unit

        val problemTryHistoryCommandUseCase = mockk<ProblemTryHistoryCommandUseCase>()
        every { problemTryHistoryCommandUseCase.execute(any()) } returns listOf(ProblemTryHistory(
            problemId = 1L,
            studentId = 1L,
            isCorrect = true,
            everCorrect = true
        ))

        tryPieceByStudentCommandFacade = TryPieceByStudentCommandFacade(
            pieceQueryUseCase = pieceQueryUseCase,
            problemQueryUseCase = problemQueryUseCase,
            pieceTryHistoryCommandUseCase = pieceTryHistoryCommandUseCase,
            problemTryHistoryCommandUseCase = problemTryHistoryCommandUseCase
        )
    }

    @Test
    fun `학생은 출제받은 문제의 답을 채점받을 수 있다`() {
        // Arrange
        val teacherId = 1L
        val studentId = 2L

        val problem = Problem(
            unitCode = "unitcode",
            level = 1,
            type = ProblemType.SELECTION,
            answer = "1"
        )
        problemRepository.save(problem)
        val piece = pieceRepository.save(
            Piece(
                title = "title",
                problems = listOf(problem.id),
                teacherId = teacherId,
            )
        )
        piecePresentToStudentRepository.saveAll(
            listOf(
                PiecePresentToStudent(
                    pieceId = piece.id,
                    studentId = studentId,
                    teacherId = teacherId,
                )
            )
        )
        // Action
        val studentAnswerResult = tryPieceByStudentCommandFacade.tryPiece(
            studentId = studentId,
            pieceId = piece.id,
            studentAnswers = listOf(
                ProblemAnswer(
                    problemId = problem.id,
                    answer = "1"
                ),
            )
        )
        // Assert
        assertThat(studentAnswerResult.first().isCorrect).isEqualTo(true)
    }
}