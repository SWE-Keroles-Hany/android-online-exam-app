package com.example.myapplication.features.exams.presentation.Screens
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.CustomTopBar
import com.example.myapplication.core.sharedCompnents.LoadingIndicator
import com.example.myapplication.features.exams.presentation.Componenets.CustomExamItem
import com.example.myapplication.features.exams.domain.models.Exam
import com.example.myapplication.features.exams.presentation.viewmodel.ExamsUiState
import com.example.myapplication.features.exams.presentation.viewmodel.ExamsViewModel
import com.example.myapplication.ui.theme.white
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ExamsScreen(
    subjectId : String? ,
    subjectTitle:String? ,
    navController: NavController)
{
    Scaffold(
        containerColor = white,
        topBar = {CustomTopBar(navController = navController, title = subjectTitle ?:"")})
    {
        innerPadding ->
        ExamScreenBody(
            subjectId = subjectId,
        )
     }}
