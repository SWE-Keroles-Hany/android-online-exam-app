package com.example.myapplication.features.results.domain.usecases

import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.exams.domain.models.Answer
import com.example.myapplication.features.results.domain.repo.ResultsRepository

class GetAnswersByQuestionIdUseCase(private val repository: ResultsRepository)
{
    suspend operator fun invoke(questionId: String): NetworkResult<List<Answer>> {
        return repository.getAnswersByQuestionId(questionId) ;
    }
}
