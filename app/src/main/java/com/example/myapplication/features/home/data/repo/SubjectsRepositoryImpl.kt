package com.example.myapplication.features.home.data.repo
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.home.data.mapper.toDomain
import com.example.myapplication.features.home.data.remote.datasource.SubjectsRemoteDataSource
import com.example.myapplication.features.home.domain.models.Subject
import com.example.myapplication.features.home.domain.repo.SubjectsRepo

class SubjectsRepositoryImpl(
    private val remoteDataSource: SubjectsRemoteDataSource
) : SubjectsRepo {

    override suspend fun getAllSubjects(): NetworkResult<List<Subject>> {
        return try {
            when (val result = remoteDataSource.getAllSubjects()) {
                is NetworkResult.Success -> {
                    NetworkResult.Success(
                        result.data.subjects.map {
                            it.toDomain()
                        }
                    )
                }

                is NetworkResult.Error -> {
                    NetworkResult.Error(result.message)
                }

                else -> {
                    NetworkResult.Error("Something went wrong")
                }
            }
        }catch (e: Exception){
            NetworkResult.Error(e.message ?: "Something went wrong")
        }
    }

    }
