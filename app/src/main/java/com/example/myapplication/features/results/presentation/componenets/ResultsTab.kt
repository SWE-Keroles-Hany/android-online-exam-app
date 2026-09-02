package com.example.myapplication.features.results.presentation.componenets
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.features.exams.domain.models.Exam
import com.example.myapplication.features.exams.presentation.Componenets.CustomExamItem
import com.example.myapplication.ui.theme.white

@Composable
fun ResultsTab() {
    val items  = listOf<Exam>(
        Exam(
            examId = "1",
            title = "Exam" ,
            active = true ,
            duration =30,
            numberOfQuestions = 30,
            subjectId ="aa",
        ),
        Exam(examId = "1",
        title = "Exam 2" ,
        active = true ,
        duration =30,
        numberOfQuestions = 30,
        subjectId ="aa",
    ),
        Exam(examId = "1",
            title = "Exam 2" ,
            active = true ,
            duration =30,
            numberOfQuestions = 30,
            subjectId ="aa",
        )

    )

    Column(
        modifier = Modifier.padding(22.dp).fillMaxSize() ,
        
    ) {
        Text("Results", style = MaterialTheme.typography.titleLarge)
        CustomHeight(20.0)
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(color = white,) ,
            ) {
            items(items){
                    item ->
                CustomExamItem(
                    title = "Exam" ,
                    to = "10AM" ,
                    from = "1AM",
                    onClick ={
                        // navigation to results screen and answer questions
                    },
                    questionsNumber = 10 ,
                    minutes = 30,
                )
                CustomHeight(14.0)

            }
        }


    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ResultsTabPreview() {
    ResultsTab()
}