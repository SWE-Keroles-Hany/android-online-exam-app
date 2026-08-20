package com.example.myapplication.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.features.auth.presentation.screens.LoginScreen
import com.example.myapplication.features.auth.presentation.screens.SignUpScreen
import com.example.myapplication.core.navigation.Screen
import com.example.myapplication.features.exams.presentation.Screens.ExamsScreen
import com.example.myapplication.features.home.presentation.Screens.HomeScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {

        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(Screen.SignUpScreen.route){
            SignUpScreen(navController=navController)
        }

        composable(Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }


        composable(Screen.ExamsScreen.route+"/{subjectId}/{subjectTitle}") {
                backStackEntry ->
val subjectId = backStackEntry.arguments?.getString("subjectId")
val subjectTitle = backStackEntry.arguments?.getString("subjectTitle")
            ExamsScreen(navController = navController , subjectId = subjectId ,
                subjectTitle = subjectTitle ,
                )

        }
    }
}