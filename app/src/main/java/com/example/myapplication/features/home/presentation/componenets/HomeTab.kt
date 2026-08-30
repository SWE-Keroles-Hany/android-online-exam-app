package com.example.myapplication.features.home.presentation.componenets
import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun HomeTab(
    modifier: Modifier = Modifier,
    navController: NavController,
    )
{
    HomeTabBody(
        modifier = modifier ,
        navController = navController)
}



