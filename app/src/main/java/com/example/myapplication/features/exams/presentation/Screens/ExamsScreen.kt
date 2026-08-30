package com.example.myapplication.features.exams.presentation.Screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.myapplication.core.sharedCompnents.CustomTopBar
import com.example.myapplication.features.exams.presentation.Componenets.ExamScreenBody
import com.example.myapplication.features.exams.presentation.viewmodel.ExamsViewModel
import com.example.myapplication.ui.theme.white

@Composable
fun ExamsScreen(
    subjectId : String? ,
    subjectTitle:String? ,
    examsViewModel: ExamsViewModel,
    navController: NavController)
{
    Scaffold(
        containerColor = white,
        topBar = {
            CustomTopBar(
                navController = navController,
                title = subjectTitle ?:"",
            )})
    {
        innerPadding ->
        ExamScreenBody(
            subjectId = subjectId,
            navController = navController,
            examsViewModel= examsViewModel,

            )
     }}
