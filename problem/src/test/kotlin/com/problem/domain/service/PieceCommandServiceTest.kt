package com.problem.domain.service

import com.problem.application.exception.ApplicationException
import com.problem.domain.repository.PiecePresentToStudentRepository
import com.problem.domain.repository.PieceRepository
import com.problem.fake.FakePiecePresentToStudentRepository
import com.problem.fake.FakePieceRepository
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class PieceCommandServiceTest {

    private lateinit var pieceCommandService: PieceCommandService
    private lateinit var pieceRepository: PieceRepository
    private lateinit var piecePresentToStudentRepository: PiecePresentToStudentRepository

    @BeforeEach
    fun setUp() {
        this.pieceRepository = FakePieceRepository()
        this.piecePresentToStudentRepository = FakePiecePresentToStudentRepository()
        this.pieceCommandService = PieceCommandService(pieceRepository, piecePresentToStudentRepository)
    }

    @Test
    fun `문제지 만들기`() {
        // Arrange
        val pieceTitle = "문제지 제목"
        val problemList = listOf(1L, 2L, 3L)
        val teacherId = 1L
        // Action
        val piece = pieceCommandService.create(pieceTitle, problemList, teacherId)
        // Assert
        assertThat(piece.title).isEqualTo(pieceTitle)
    }

    @Test
    fun `문제지 50개 이상시 예외발생`() {
        // Arrange
        val pieceTitle = "문제지 제목"
        val problemList = (1..51).map { it.toLong() }
        val teacherId = 1L
        // Action, Assert
        assertThatThrownBy { pieceCommandService.create(pieceTitle, problemList, teacherId) }
            .isInstanceOf(ApplicationException::class.java)
    }

    @Test
    fun `2인이상 학생에게 문제지 출제하기`() {
        // Arrange
        val pieceTitle = "문제지 제목"
        val problemList = listOf(1L, 2L, 3L)
        val teacherId = 1L
        val piece = pieceCommandService.create(pieceTitle, problemList, teacherId)
        val studentIds = listOf(1L, 2L, 3L)
        // Action
        val presentPieceResult = pieceCommandService.presentPieceToStudents(piece.id, studentIds, teacherId)
        // Assert
        assertThat(presentPieceResult.receivedStudents).isEqualTo(studentIds)
    }

    @Test
    fun `2인이상 학생에게 문제지 출제하기-선생님이 지급한문제가 아닌경우 예외`() {
        // Arrange
        val pieceTitle = "문제지 제목"
        val problemList = listOf(1L, 2L, 3L)
        val teacherId = 1L
        val piece = pieceCommandService.create(pieceTitle, problemList, teacherId)
        val studentIds = listOf(1L, 2L, 3L)
        // Action, Assert
        assertThatThrownBy { pieceCommandService.presentPieceToStudents(piece.id, studentIds, 2L) }
            .isInstanceOf(ApplicationException::class.java)
    }

    @Test
    fun `2인이상 학생에게 문제지 출제하기-문제지가 없는경우 예외`() {
        // Arrange
        val pieceTitle = "문제지 제목"
        val problemList = listOf(1L, 2L, 3L)
        val teacherId = 1L
        val piece = pieceCommandService.create(pieceTitle, problemList, teacherId)
        val wrongPieceId = 2L
        val studentIds = listOf(1L, 2L, 3L)
        // Action, Assert
        assertThatThrownBy { pieceCommandService.presentPieceToStudents(wrongPieceId, studentIds, teacherId) }
            .isInstanceOf(ApplicationException::class.java)
    }
}