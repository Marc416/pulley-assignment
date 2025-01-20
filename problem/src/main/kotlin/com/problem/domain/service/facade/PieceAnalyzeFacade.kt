package com.problem.domain.service.facade

import com.problem.application.controller.response.PieceAnalyzeResponse
import com.problem.domain.entity.PiecePresentToStudent
import com.problem.domain.usecase.PiecePresentToStudentQueryUseCase
import com.problem.domain.usecase.PieceQueryUseCase
import com.problem.domain.usecase.facade.PieceAnalyzeFacadeUseCase
import com.problem.domain.usecase.history.PieceTryHistoryQueryUseCase
import com.problem.domain.usecase.history.ProblemTryHistoryQueryUseCase
import org.springframework.stereotype.Service

@Service
class PieceAnalyzeFacade(
    private val pieceQueryUseCase: PieceQueryUseCase,
    private val piecePresentToStudentQueryUseCase: PiecePresentToStudentQueryUseCase,
    private val pieceTryHistoryQueryUseCase: PieceTryHistoryQueryUseCase,
    private val problemTryHistoryQueryUseCase: ProblemTryHistoryQueryUseCase
) : PieceAnalyzeFacadeUseCase {
    override fun analyze(teacherId: Long, pieceId: Long): PieceAnalyzeResponse {
        val piece = pieceQueryUseCase.findByTeacherIdAndPieceId(teacherId, pieceId)
        val piecePresentToStudents = piecePresentToStudentQueryUseCase.findByTeacherIdAndPieceId(teacherId, pieceId)
        val students = getPresentedStudents(piecePresentToStudents)
        val studentIds = students.map { it.id }
        val pieceTryHistories = pieceTryHistoryQueryUseCase.findByPieceIdAndStudentIds(pieceId, studentIds)
        val resultPerProblems = problemTryHistoryQueryUseCase.findByProblemIdsAndStudentIds(piece.problems, studentIds)
        return PieceAnalyzeResponse(
            pieceId = piece.id,
            title = piece.title,
            students = students,
            resultsPerStudents = pieceTryHistories.map {
                PieceAnalyzeResponse.ResultPerStudent(
                    it.studentId,
                    it.score,
                )
            },
            resultsPerProblems = resultPerProblems.map {
                PieceAnalyzeResponse.ResultPerProblem.of(it)
            }

        )
    }

    // 학생의 정보는 Port Out으로 조회해 이름과 필요한 정보를 가져와야하지만 과제에 이와 같은 사항은 제외해도 된다고 명시돼 있으므로 아래와 같이 임시로 작성했습니다.
    private fun getPresentedStudents(piecePresentToStudents: List<PiecePresentToStudent>): List<PieceAnalyzeResponse.Student> {
        return piecePresentToStudents.map {
            PieceAnalyzeResponse.Student(
                it.studentId,
                "임시이름" + it.studentId.toString()
            )
        }
    }
}