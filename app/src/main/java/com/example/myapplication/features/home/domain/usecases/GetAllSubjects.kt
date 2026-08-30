package com.example.myapplication.features.home.domain.usecases
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.home.domain.models.Subject
import com.example.myapplication.features.home.domain.repo.SubjectsRepo

class GetAllSubjects (private  val repository: SubjectsRepo){
    suspend operator fun invoke() : NetworkResult<List<Subject>> {
        return repository.getAllSubjects() ;
    }
}