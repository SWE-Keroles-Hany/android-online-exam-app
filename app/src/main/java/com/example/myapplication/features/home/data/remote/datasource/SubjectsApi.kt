package com.example.myapplication.features.home.data.remote.datasource
import com.example.myapplication.features.home.data.remote.dto.SubjectResults
import retrofit2.Response
import retrofit2.http.GET

interface SubjectsApi
{
    @GET("subjects")
    suspend fun getAllSubjects() : Response<SubjectResults>


}