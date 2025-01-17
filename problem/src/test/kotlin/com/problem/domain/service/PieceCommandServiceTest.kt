package com.problem.domain.service

import com.problem.domain.repository.PieceRepository
import com.problem.fake.FakePieceRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class PieceCommandServiceTest {

    private lateinit var pieceCommandService: PieceCommandService
    private lateinit var pieceRepository: PieceRepository

    @BeforeEach
    fun setUp() {
        this.pieceRepository = FakePieceRepository()
        this.pieceCommandService = PieceCommandService(pieceRepository)
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
}