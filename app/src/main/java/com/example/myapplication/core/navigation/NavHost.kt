package com.example.myapplication.core.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.features.auth.presentation.screens.LoginScreen
import com.example.myapplication.features.auth.presentation.screens.SignUpScreen
import com.example.myapplication.core.navigation.Screen
import com.example.myapplication.features.exams.presentation.Screens.ExamInstructionsScreen
import com.example.myapplication.features.exams.presentation.Screens.ExamsScreen
import com.example.myapplication.features.exams.presentation.Screens.QuestionsScreen
import com.example.myapplication.features.home.presentation.Screens.HomeScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
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
        composable(Screen.ExamInstructionsScreen.route +"/{title}/{duration}/{numOfQuestions}/{examId}"){
            backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val examId = backStackEntry.arguments?.getString("examId") ?: ""

            val duration =
                backStackEntry.arguments?.getString("duration")?.toIntOrNull() ?: 0

            val numOfQuestions =
                backStackEntry.arguments
                    ?.getString("numOfQuestions")
                    ?.toIntOrNull() ?: 0

            ExamInstructionsScreen(
                navController = navController,
                title = title,
                duration = duration,
                numOfQuestions = numOfQuestions ,
                examId =examId,
            )


        }
        composable(Screen.QuestionsScreen.route +"/{examId}"+"/{numOfQuestions}"+"/{duration}") {
            backStackEntry ->
            val examId = backStackEntry.arguments?.getString("examId") ?: ""
            val duration =
                backStackEntry.arguments?.getString("duration")?.toIntOrNull() ?: 0
            val numOfQuestions =
                backStackEntry.arguments
                    ?.getString("numOfQuestions")
                    ?.toIntOrNull() ?: 0
            QuestionsScreen(navController = navController ,
                examId = examId,numOfQuestions=numOfQuestions ,

                duration = duration ,
                )
        }

    }
}

/*
3- countdown timer (after terminate timer)
4- type of questions (single choice , multiple choice)
5- results/ view scores

*/