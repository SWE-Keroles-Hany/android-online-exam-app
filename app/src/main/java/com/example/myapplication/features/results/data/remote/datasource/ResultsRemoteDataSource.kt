package com.example.myapplication.features.results.data.remote.datasource
import android.util.Log
import com.example.myapplication.core.network.NetworkResult
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
}