package com.example.myapplication.features.exams.domain.repo

import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.exams.domain.models.Exam
import com.example.myapplication.features.exams.domain.models.Question

interface ExamsRepository {

    suspend fun getExamsBySubjectId(subjectId: String):NetworkResult<List<Exam>>
    suspend fun getQuestionsByExamId(examId: String):NetworkResult<List<Question>>

}