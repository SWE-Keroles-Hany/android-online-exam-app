package com.example.myapplication.features.home.data.remote.datasource

import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.home.data.remote.dto.SubjectResults

class SubjectsRemoteDataSource(
    private val subjectsApi: SubjectsApi
) {
    suspend fun getAllSubjects(): NetworkResult<SubjectResults> {
        return try {
            val response = subjectsApi.getAllSubjects()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    NetworkResult.Success(body)
                } else {
                    NetworkResult.Error("Response body is empty")
                }

            } else {
                NetworkResult.Error(
                    "Request failed: ${response.code()}"
                )
            }

        } catch (e: Exception) {

            NetworkResult.Error(
                e.message ?: "Something went wrong"
            )
        }
    }
}