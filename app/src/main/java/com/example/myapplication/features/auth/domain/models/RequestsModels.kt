package com.example.myapplication.features.auth.domain.models

data class LoginRequest(
    val email:String ,
    val password : String
)


data class SignupRequest(
    val username:String ,
    val firstName : String ,
    val lastName : String ,
    val phone : String ,
    val password : String ,
    val rePassword:String ,
    val email : String
)
