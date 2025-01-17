package com.problem.domain.dto.problem

enum class ProblemType(val description: String) {
    ALL("전체"),
    SELECTION("객관식"),
    SUBJECTIVE("주관식");
    fun getValue():List<ProblemType>{
        if (this==ALL){
            return listOf(SELECTION, SUBJECTIVE)
        }
        return listOf(this)
    }
}