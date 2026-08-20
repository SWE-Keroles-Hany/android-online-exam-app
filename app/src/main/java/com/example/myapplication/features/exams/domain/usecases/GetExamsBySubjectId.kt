package com.example.myapplication.features.exams.domain.usecases

import com.example.myapplication.features.exams.domain.repo.ExamsRepository

class GetExamsBySubjectId(
    private  val repository: ExamsRepository

) {
    suspend operator fun invoke (subjectId: String) = repository.getExamsBySubjectId(subjectId)
}