package com.example.myapplication.core.validation

import android.util.Patterns

class AppValidation {
    fun validatePhoneNumber(phoneNumber:String):String?{
        return when {
            phoneNumber.isBlank() -> "Phone Number is required"
            phoneNumber.length <11
                -> "Invalid Phone Number"
            else -> null
        }
    }
    fun validateEmail(email: String): String? {
        return when {
            email.isBlank() -> "Email is required"
            !Patterns.EMAIL_ADDRESS .matcher(email).matches()
                -> "Invalid email"
            else -> null
        }
    }
    fun validateName(name: String): String? {
        return when {
            name.isBlank() -> "Name is required"
            name.length <3
                -> "Invalid Name"
            else -> null
        }
    }

    fun validatePassword(password: String): String? {
        return when {
            password.isBlank() -> "Password is required"
            password.length < 8 -> "Password must be at least 8 characters"
            else -> null }


    }
}