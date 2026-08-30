package com.example.myapplication.features.auth.presentation.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.auth.domain.models.LoginRequest
import com.example.myapplication.features.auth.domain.models.SignupRequest
import com.example.myapplication.features.auth.domain.usecases.LoginUseCase
import com.example.myapplication.features.auth.domain.usecases.SignupUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val loginUseCase: LoginUseCase,
    private val signupUseCase: SignupUseCase
) : ViewModel() {

    private val _loginState = MutableStateFlow<NetworkResult<Unit>?>(null)
    val loginState: StateFlow<NetworkResult<Unit>?> = _loginState

    private val _signupState = MutableStateFlow<NetworkResult<Unit>?>(null)
    val signupState: StateFlow<NetworkResult<Unit>?> = _signupState


    fun login(loginRequest: LoginRequest) {

        viewModelScope.launch {

            _loginState.value = NetworkResult.Loading
            delay(2000)

            try {

                _loginState.value = loginUseCase(loginRequest)

            } catch (e: Exception) {

                _loginState.value = NetworkResult.Error(
                    e.message ?: "Something went wrong"
                )
            }
        }
    }

    fun signup(signupRequest: SignupRequest) {

        viewModelScope.launch {

            _signupState.value = NetworkResult.Loading

            try {

                _signupState.value = signupUseCase(signupRequest)

            } catch (e: Exception) {

                _signupState.value = NetworkResult.Error(
                    e.message ?: "Something went wrong"
                )
            }
        }
    }


    fun clearLoginState() {
        _loginState.value = null
    }

    fun clearSignupState() {
        _signupState.value = null
    }
}