package com.example.myapplication.features.results.domain.repo
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.exams.data.remote.dto.questions.QuestionsResults
import com.example.myapplication.features.exams.domain.models.Answer
import com.example.myapplication.features.exams.domain.models.Question
import com.example.myapplication.features.results.domain.models.CheckAnswersRequest
import com.example.myapplication.features.results.domain.models.CheckAnswersResponse
import com.example.myapplication.features.results.domain.models.GeneralQuestion

interface ResultsRepository {
    suspend fun checkAnswers(checkAnswersRequest: CheckAnswersRequest): NetworkResult<CheckAnswersResponse>
    suspend fun getAnswersByQuestionId(questionId: String): NetworkResult<List<Answer>>

}