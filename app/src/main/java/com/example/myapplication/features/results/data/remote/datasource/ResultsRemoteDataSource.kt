package com.example.myapplication.features.results.data.remote.datasource
import android.util.Log
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.exams.data.remote.dto.questions.AnswerDto
import com.example.myapplication.features.exams.data.remote.dto.questions.QuestionDto
import com.example.myapplication.features.exams.data.remote.dto.questions.QuestionsResults
import com.example.myapplication.features.exams.domain.models.Answer
import com.example.myapplication.features.results.data.remote.dto.CheckAnswersRequestDto
import com.example.myapplication.features.results.data.remote.dto.CheckAnswersResponseDto

class ResultsRemoteDataSource (private val answersApi:ResultsApi){
    suspend fun checkAnswers(
        checkAnswersRequest: CheckAnswersRequestDto
    ): NetworkResult<CheckAnswersResponseDto> {
    return try {
        val response = answersApi.checkAnswers(checkAnswersRequest)
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                Log.d("TAG","correctQuestions size in ds: ${body.correctQuestions.size}")
                Log.d("TAG","WrongQuestions size in ds: ${body.WrongQuestions.size}")

                NetworkResult.Success(body)
            } else {

                NetworkResult.Error(response.errorBody().toString())
            }
        } else {
            Log.d("TAG","Error ${response.errorBody()}")
            NetworkResult.Error(response.code().toString()?:"code ")

        }


    }catch (e:Exception){
        NetworkResult.Error(e.message)}
    }

    suspend fun getAnswersByQuestionId(
        questionId: String
    ): NetworkResult<QuestionDto> {
        return try {
            val response = answersApi.getAnswersByQuestionId(questionId)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    NetworkResult.Success(body.question)
                } else {
                    NetworkResult.Error(response.errorBody().toString())
                }
            } else {
                NetworkResult.Error(response.code().toString()?:"code ")

            }


        }catch (e:Exception){
            NetworkResult.Error(e.message)}
    }
}