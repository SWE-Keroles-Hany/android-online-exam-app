package com.example.myapplication.core.navigation

sealed class Screen(val route: String) {
    object LoginScreen : Screen("loginScreen")
    object SignUpScreen : Screen("signUpScreen")
    object LanguageExamsScreen : Screen("languageExamScreen")
    object MathExamsScreen : Screen("mathExamScreen")
    object ArtExamsScreen : Screen("artExamScreen")
    object ScienceExamsScreen : Screen("scienceExamScreen")

    object HomeScreen : Screen("homeScreen")


}
