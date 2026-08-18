package com.example.myapplication.features.exams.presentation.Screens

import android.R.attr.navigationIcon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.core.sharedCompnents.CustomTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScienceExamsScreen(
    navController: NavController,
    modifier: Modifier = Modifier)
{
    Scaffold(
    topBar = {
        CustomTopBar(
            navController = navController
            , title = "Science")

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

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//private fun ScienceExamsScreenPreview() {
//    ScienceExamsScreen(navController = NavController(LocalContext.current))
//
//}