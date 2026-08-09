package com.example.myapplication.features.auth.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun SignUpScreen(
    navController: NavController,
    modifier: Modifier = Modifier) {
    Column()
    {
        // * Icon
        // * Text => create account
        // * User -> Name
        // * First name - Last name
        // * Email
        // * Password - Confirm password
        Text("Sign Up Screen")
    }
}