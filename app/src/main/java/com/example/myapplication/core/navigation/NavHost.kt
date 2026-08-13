package com.example.myapplication.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.features.auth.presentation.screens.LoginScreen
import com.example.myapplication.features.auth.presentation.screens.SignUpScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {

        composable(Screen.Login.route) {
            LoginScreen(

                navController = navController)
        }

        composable(Screen.SignUp.route){
            SignUpScreen(

                navController=navController)
        }
        composable(Screen.Home.route) {  }
    }
}