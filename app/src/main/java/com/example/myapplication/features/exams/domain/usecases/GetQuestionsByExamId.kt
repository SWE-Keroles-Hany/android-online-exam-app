package com.example.myapplication.features.exams.domain.usecases

import com.example.myapplication.features.exams.domain.repo.ExamsRepository

class GetQuestionsByExamId (
    private  val repository: ExamsRepository
) {
    suspend operator fun invoke (examId: String) = repository.getQuestionsByExamId(examId)

}

