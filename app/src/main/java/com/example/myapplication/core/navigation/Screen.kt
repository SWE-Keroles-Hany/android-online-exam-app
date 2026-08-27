package com.example.myapplication.core.navigation

sealed class Screen(val route: String) {
    object LoginScreen : Screen("loginScreen")
    object SignUpScreen : Screen("signUpScreen")
    object ExamsScreen : Screen("examsScreen")
    object HomeScreen : Screen("homeScreen")
    object ExamInstructionsScreen : Screen("examInstructionsScreen")
    object QuestionsScreen : Screen("questionsScreen")
    object ExamScoreScreen : Screen(route = "ExamScoreScreen")
    object AnswersScreen : Screen(route = "AnswersScreen")

}
