package com.example.myapplication.features.home.data.remote.datasource

import com.example.myapplication.features.home.data.remote.dto.SubjectDto
import com.example.myapplication.features.home.data.remote.dto.SubjectResults
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.security.auth.Subject

interface SubjectsApi
{
    @GET("subjects")
    suspend fun getAllSubjects() : Response<SubjectResults>


}