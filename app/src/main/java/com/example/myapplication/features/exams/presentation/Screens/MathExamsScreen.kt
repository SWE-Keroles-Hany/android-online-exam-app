package com.example.myapplication.features.exams.presentation.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.myapplication.core.sharedCompnents.CustomTopBar

@Composable
fun MathExamsScreen(modifier: Modifier = Modifier ,navController: NavController)
{
    Scaffold(
    topBar = {
        CustomTopBar(
            navController = navController
            , title = "Math")

    }

) {
        innerPadding ->
    Column(
        modifier = Modifier.padding(innerPadding)
    ) {

        Text("Home Screen")
    }

}

}