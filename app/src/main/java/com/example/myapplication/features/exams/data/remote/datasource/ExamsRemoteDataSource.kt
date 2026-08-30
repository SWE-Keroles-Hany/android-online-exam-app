package com.example.myapplication.features.exams.data.remote.datasource
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.exams.data.remote.dto.exam.ExamDto
import com.example.myapplication.features.exams.data.remote.dto.questions.QuestionDto

class ExamsRemoteDataSource(private  val examsApi: ExamsApi) {


    suspend fun getExamsBySubjectId(subjectId: String): NetworkResult<List<ExamDto>> {

        return try {
            val response = examsApi.getExamsBySubjectId(subjectId);
            if(response.isSuccessful){
                val results = response.body();
                if(results == null){
                    NetworkResult.Error((response.errorBody() ?:"aaa") as String?)
                }else{
                    NetworkResult.Success(results.exams) ;
                }
                }else{
                NetworkResult.Error("Some Thing Went Wrong")
            }


        }catch (e: Exception){
            NetworkResult.Error(e.message?:"Some Thing Went Wrong")
        }
    }


    suspend fun getQuestionsByExamId(exam: String): NetworkResult<List<QuestionDto>> {

        return try {
            val response = examsApi.getQuestionsByExamId(exam);
            if(response.isSuccessful){
                val results = response.body();
                if(results == null){
                    NetworkResult.Error((response.errorBody() ?:"aaa") as String?)
                }else{
                    NetworkResult.Success(results.questions) ;
                }
            }else{
                NetworkResult.Error("Some Thing Went Wrong")
            }


        }catch (e: Exception){
            NetworkResult.Error(e.message?:"Some Thing Went Wrong")
        }
    }




}