package com.example.myapplication.core.network
sealed class NetworkResult<out T> {

    data class Success<T>(
        val data: T
    ) : NetworkResult<T>()

    data class Error(
        val message: String?,
    ) : NetworkResult<Nothing>()

    data object Loading : NetworkResult<Nothing>()
}
