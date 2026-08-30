package com.example.myapplication.features.home.domain.repo
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.home.domain.models.Subject

interface SubjectsRepo {
    suspend fun getAllSubjects(): NetworkResult<List<Subject>>
}
