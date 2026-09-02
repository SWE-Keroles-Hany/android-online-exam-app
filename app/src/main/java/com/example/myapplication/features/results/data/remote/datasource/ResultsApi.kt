package com.example.myapplication.features.results.data.remote.datasource
import com.example.myapplication.features.exams.data.remote.dto.questions.QuestionDto
import com.example.myapplication.features.exams.data.remote.dto.questions.QuestionsResults
import com.example.myapplication.features.exams.domain.models.Answer
import com.example.myapplication.features.exams.domain.models.Question
import com.example.myapplication.features.results.data.remote.dto.CheckAnswersRequestDto
import com.example.myapplication.features.results.data.remote.dto.CheckAnswersResponseDto
import com.example.myapplication.features.results.data.remote.dto.SingleQuestionResult
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ResultsApi {
    @POST("questions/check")
    suspend fun checkAnswers(
        @Body checkAnswersRequest: CheckAnswersRequestDto
    ): Response<CheckAnswersResponseDto>


    @GET("questions/{questionId}")
    suspend fun getAnswersByQuestionId(
        @Path("questionId") questionId: String
    ): Response<SingleQuestionResult>


}
