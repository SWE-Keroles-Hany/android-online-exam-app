package com.example.myapplication.features.exams.data.repo
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.exams.data.mapper.toDomain
import com.example.myapplication.features.exams.data.remote.datasource.ExamsRemoteDataSource
import com.example.myapplication.features.exams.domain.models.Exam
import com.example.myapplication.features.exams.domain.models.Question
import com.example.myapplication.features.exams.domain.repo.ExamsRepository

class ExamsRepositoryImpl(
    private  val examsRemoteDataSource: ExamsRemoteDataSource
): ExamsRepository {
    override suspend fun getExamsBySubjectId(subjectId: String): NetworkResult<List<Exam>> {
        return try {
            when(val response = examsRemoteDataSource.getExamsBySubjectId(subjectId)){
                is NetworkResult.Success ->{
                    NetworkResult.Success(response.data.map { it.toDomain() })
                }
                is NetworkResult.Error ->{
                    NetworkResult.Error(response.message)
                }

                else -> {
                    NetworkResult.Error("Some Thing Went Wrong")
                }
            }


        }catch (e: Exception){
            NetworkResult.Error(e.message)

        }
    }

    override suspend fun getQuestionsByExamId(examId: String): NetworkResult<List<Question>> {
        return try {
            when(val response = examsRemoteDataSource.getQuestionsByExamId(examId)){
                is NetworkResult.Success ->{
                    NetworkResult.Success(response.data.map { it.toDomain() })
                }
                is NetworkResult.Error ->{
                    NetworkResult.Error(response.message)
                }

                else -> {
                    NetworkResult.Error("Some Thing Went Wrong")
                }
            }


        }catch (e: Exception){
            NetworkResult.Error(e.message)

        }
    }


}