package com.example.myapplication.features.results.data.remote.repo
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.exams.data.mapper.toDomain
import com.example.myapplication.features.exams.data.remote.dto.questions.QuestionsResults
import com.example.myapplication.features.exams.domain.models.Answer
import com.example.myapplication.features.exams.domain.models.Question
import com.example.myapplication.features.results.data.remote.datasource.ResultsRemoteDataSource
import com.example.myapplication.features.results.data.remote.mapper.toDomain
import com.example.myapplication.features.results.data.remote.mapper.toModel
import com.example.myapplication.features.results.domain.models.CheckAnswersRequest
import com.example.myapplication.features.results.domain.models.CheckAnswersResponse
import com.example.myapplication.features.results.domain.repo.ResultsRepository

class ResultsRepositoryImpl(
    private val remoteDataSource: ResultsRemoteDataSource
): ResultsRepository {
    override suspend fun checkAnswers(checkAnswersRequest: CheckAnswersRequest): NetworkResult<CheckAnswersResponse> {
        return try {
            when (val response = remoteDataSource.checkAnswers(checkAnswersRequest.toModel())) {
                is NetworkResult.Success -> {
                    NetworkResult.Success(response.data.toDomain())
                }

                is NetworkResult.Error -> {
                    NetworkResult.Error(response.message)
                }

                else -> {
                    NetworkResult.Error("Some Thing Went Wrong")
                }
            }
        }catch (e:Exception){
            NetworkResult.Error(e.message)
        }
    }

    override suspend fun getAnswersByQuestionId(questionId: String): NetworkResult<List<Answer>> {
        return try {
            when (val response = remoteDataSource.getAnswersByQuestionId(questionId)) {
                is NetworkResult.Success -> {
                   val answers = response.data.answers.map {
                       it -> it.toDomain()
                   };
                    NetworkResult.Success(answers)

                }

                is NetworkResult.Error -> {
                    NetworkResult.Error(response.message)
                }

                else -> {
                    NetworkResult.Error("Some Thing Went Wrong")
                }
            }
        }catch (e:Exception){
            NetworkResult.Error(e.message)
        }
    }
}