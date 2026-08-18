package com.example.myapplication.features.home.presentation.componenets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.features.home.domain.models.Subject
import com.example.myapplication.features.home.presentation.viewmodel.SubjectUiState
import com.example.myapplication.features.home.presentation.viewmodel.SubjectsViewModel
import com.example.myapplication.ui.theme.primaryColor
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeTabBody(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SubjectsViewModel = koinViewModel() )
{
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var textFieldState by remember { mutableStateOf(TextFieldState()) }



    Column(
        Modifier.fillMaxSize().padding(22.dp)
    ) {
        CustomHeight(16.0)
        // label
        Text("Survey" ,
            style = MaterialTheme.typography.titleLarge.copy(
                color = primaryColor ,
                fontWeight = FontWeight.W500))

        // search text field
        CustomHeight(16.0)
        SimpleSearchBar(
            textFieldState = textFieldState,
        )
        CustomHeight(40.0)
        Text("Browse by subject" ,
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.W500))
        CustomHeight(24.0)
        when (uiState) {
            is SubjectUiState.Loading -> {
                CircularProgressIndicator()
            }

            is SubjectUiState.Success -> {
                LazyColumn(
                    contentPadding = PaddingValues(
                        top = 10.dp,
                        bottom =80.dp),

                    modifier = Modifier.fillMaxSize()
                        .weight(1f)
                ) {
                    val subjectList : List<Subject> = (uiState as SubjectUiState.Success).subjects;
                    items(subjectList) { item ->

                        CustomSubject(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp).clickable {
                                },
                            imgURL = item.icon,
                            title = item.name
                        )
                    }
                }
            }

            else -> {
                Text(uiState.toString())
            }
        }



    }
}

