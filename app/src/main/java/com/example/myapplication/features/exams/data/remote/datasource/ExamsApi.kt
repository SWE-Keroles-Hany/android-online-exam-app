package com.example.myapplication.features.exams.data.remote.datasource

import com.example.myapplication.features.exams.data.remote.dto.exam.ExamResults
import com.example.myapplication.features.exams.data.remote.dto.questions.QuestionsResults
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ExamsApi {

    @GET("exams")
    suspend fun getExamsBySubjectId(
        @Query("subject") subjectId: String
    ): Response<ExamResults>

    @GET("questions")
    suspend fun getQuestionsByExamId(
        @Query("exam") examId: String
    ) : Response<QuestionsResults>


}