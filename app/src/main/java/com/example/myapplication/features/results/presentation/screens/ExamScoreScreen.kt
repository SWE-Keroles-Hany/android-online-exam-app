package com.example.myapplication.features.results.presentation.screens

import android.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.core.navigation.Screen
import com.example.myapplication.core.sharedCompnents.CustomButton
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.CustomTopBar
import com.example.myapplication.features.home.presentation.Screens.HomeScreen
import com.example.myapplication.features.results.presentation.componenets.CorrectAndInCorrectInfo
import com.example.myapplication.features.results.presentation.componenets.CustomCircleProgress
import com.example.myapplication.features.results.presentation.componenets.CustomResultItem
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.red
import com.example.myapplication.ui.theme.white

@Composable
fun ExamScoreScreen(navController: NavController) {
    Scaffold(
        containerColor = white,
        topBar = {
            CustomTopBar(
                showNavigationIcon = false ,
                navController = navController,
                title = "Exam Score"
            )
        },
    ) {

        innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(22.dp)
                .fillMaxSize()
        ) {
            Text("Your Score" , style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold ,
            ))

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                CustomCircleProgress(0.5F)
                CorrectAndInCorrectInfo(
                    correct = 2,
                    inCorrect = 1
                )
            }
            CustomHeight(80.0)
            CustomButton(
                bgColor = primaryColor ,
                onClick = {} ,
                title = "Show Results",
                borderColor = white ,
                titleColor = white ,
            )
            CustomHeight(20.0)
            CustomButton(
                bgColor = white ,
                onClick = {
                    navController.navigate(Screen.HomeScreen.route)
                } ,
                title = "Start Again" ,
                borderColor = primaryColor,
                titleColor = primaryColor,
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ExamScoreScreenPreview() {
    ExamScoreScreen(
        navController = NavController(LocalContext.current)
    )
}
