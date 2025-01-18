package com.problem.domain.service.facade

import com.problem.application.exception.ApplicationException
import com.problem.domain.dto.problem.ProblemType
import com.problem.domain.entity.Piece
import com.problem.domain.entity.Problem
import com.problem.domain.repository.PiecePresentToStudentRepository
import com.problem.domain.repository.PieceRepository
import com.problem.domain.repository.ProblemDetailRepository
import com.problem.domain.repository.ProblemRepository
import com.problem.domain.service.PieceCommandService
import com.problem.domain.service.PieceQueryService
import com.problem.domain.service.ProblemDetailQueryService
import com.problem.domain.service.ProblemQueryService
import com.problem.domain.usecase.PieceQueryUseCase
import com.problem.domain.usecase.ProblemDetailQueryUseCase
import com.problem.domain.usecase.ProblemQueryUseCase
import com.problem.domain.usecase.facade.ProblemQueryByPieceFacadeUseCase
import com.problem.fake.FakePiecePresentToStudentRepository
import com.problem.fake.FakePieceRepository
import com.problem.fake.FakeProblemDetailRepository
import com.problem.fake.FakeProblemRepository
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class ProblemQueryByPieceFacadeTest {
    lateinit var problemQueryByPieceFacade: ProblemQueryByPieceFacadeUseCase
    lateinit var pieceQueryUseCase: PieceQueryUseCase
    lateinit var problemQueryUseCase: ProblemQueryUseCase
    lateinit var problemDetailQueryUseCase: ProblemDetailQueryUseCase
    lateinit var pieceCommandService: PieceCommandService

    lateinit var pieceRepository: PieceRepository
    lateinit var problemRepository: ProblemRepository
    lateinit var piecePresentToStudentRepository: PiecePresentToStudentRepository
    lateinit var problemDetailRepository: ProblemDetailRepository

    @BeforeEach
    fun setUp() {
        this.pieceRepository = FakePieceRepository()
        this.problemRepository = FakeProblemRepository()
        this.piecePresentToStudentRepository = FakePiecePresentToStudentRepository()
        this.problemDetailRepository = FakeProblemDetailRepository()
        this.pieceQueryUseCase = PieceQueryService(
            pieceRepository = pieceRepository,
            piecePresentToStudentRepository = piecePresentToStudentRepository
        )

        this.problemQueryUseCase = ProblemQueryService(
            problemRepository = problemRepository
        )
        this.problemDetailQueryUseCase = ProblemDetailQueryService(
            problemDetailRepository = problemDetailRepository
        )

        this.pieceCommandService = PieceCommandService(
            pieceRepository = pieceRepository,
            piecePresentToStudentRepository = piecePresentToStudentRepository
        )


        problemQueryByPieceFacade = ProblemQueryByPieceFacade(
            pieceQueryUseCase = pieceQueryUseCase,
            problemQueryUseCase = problemQueryUseCase,
            problemDetailQueryUseCase = problemDetailQueryUseCase
        )
    }

    @Test
    fun `학생은 출제받은 문제를 조회할 수 있다`() {
        // Arrange
        val teacherId = 1L
        val studentId = 2L
        val problem1 = Problem(unitCode = "unit1", type = ProblemType.SELECTION, answer = "1", level = 1)
        val problem2 = Problem(unitCode = "unit1", type = ProblemType.SELECTION, answer = "2", level = 1)
        val problem3 = Problem(unitCode = "unit1", type = ProblemType.SELECTION, answer = "3", level = 1)
        val problem1Saved = problemRepository.save(problem1)
        val problem2Saved = problemRepository.save(problem2)
        val problem3Saved = problemRepository.save(problem3)
        val piece = Piece(
            title = "piece1",
            problems = listOf(problem1Saved.id, problem2Saved.id, problem3Saved.id),
            teacherId = teacherId
        )
        pieceRepository.save(piece)
        pieceCommandService.presentPieceToStudents(
            piece.id,
            listOf(studentId),
            teacherId
        )
        // Action
        val result = problemQueryByPieceFacade.findProblemDetailByPieceId(studentId, pieceId = piece.id)
        // Assert
        assertThat(result.problems.count()).isEqualTo(piece.problems.count())
    }

    @Test
    fun `존재하지 않는 학습지인경우 예외발생`(){
        // Arrange
        val teacherId = 1L
        val studentId = 2L
        val problem1 = Problem(unitCode = "unit1", type = ProblemType.SELECTION, answer = "1", level = 1)
        val problem2 = Problem(unitCode = "unit1", type = ProblemType.SELECTION, answer = "2", level = 1)
        val problem3 = Problem(unitCode = "unit1", type = ProblemType.SELECTION, answer = "3", level = 1)
        val problem1Saved = problemRepository.save(problem1)
        val problem2Saved = problemRepository.save(problem2)
        val problem3Saved = problemRepository.save(problem3)
        val piece = Piece(
            title = "piece1",
            problems = listOf(problem1Saved.id, problem2Saved.id, problem3Saved.id),
            teacherId = teacherId
        )
        pieceRepository.save(piece)
        pieceCommandService.presentPieceToStudents(
            piece.id,
            listOf(studentId),
            teacherId
        )
        // Action, Assert
        assertThatThrownBy { problemQueryByPieceFacade.findProblemDetailByPieceId(studentId, pieceId = 30L) }
            .isInstanceOf(ApplicationException::class.java)
    }
}