package com.example.myapplication.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.features.auth.presentation.screens.LoginScreen
import com.example.myapplication.features.auth.presentation.screens.SignUpScreen
import com.example.myapplication.features.exams.presentation.Screen.ExamInstructionsScreen
import com.example.myapplication.features.exams.presentation.Screens.ExamsScreen
import com.example.myapplication.features.exams.presentation.Screens.QuestionsScreen
import com.example.myapplication.features.exams.presentation.viewmodel.ExamsViewModel
import com.example.myapplication.features.home.presentation.Screens.HomeScreen
import com.example.myapplication.features.results.domain.models.SelectedAnswer
import com.example.myapplication.features.results.presentation.screens.AnswersScreen
import com.example.myapplication.features.results.presentation.screens.ExamScoreScreen
import org.koin.compose.viewmodel.koinViewModel
import kotlin.collections.emptyList
import kotlin.concurrent.timer

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val examViewModel: ExamsViewModel = koinViewModel()
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
                examsViewModel = examViewModel
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
            QuestionsScreen(
                navController = navController ,
                examId = examId, duration = duration,
                examsViewModel= examViewModel
                )
        }

        composable(Screen.ExamScoreScreen.route+"/{time}"){
            backStackEntry ->
            val time =
                backStackEntry.arguments
                    ?.getInt("time")

            ExamScoreScreen(navController = navController,time = time?:0, examsViewModel = examViewModel)
        }
        composable ( Screen.AnswersScreen.route ){
            AnswersScreen(navController = navController)
        }


    }


}

/*
2- results/ view scores

*/