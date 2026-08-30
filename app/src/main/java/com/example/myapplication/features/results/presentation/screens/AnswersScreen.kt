package com.example.myapplication.features.results.presentation.screens
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.CustomTopBar
import com.example.myapplication.core.sharedCompnents.CustomWidth
import com.example.myapplication.features.results.presentation.viewmodel.ResultsViewModel
import com.example.myapplication.ui.theme.error
import com.example.myapplication.ui.theme.lightGreen
import com.example.myapplication.ui.theme.lightRed
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.success
import com.example.myapplication.ui.theme.white
import com.example.myapplication.ui.theme.whiteBlue
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AnswersScreen(navController: NavController ,
                  resultsViewModel : ResultsViewModel = koinViewModel(),
)
{
 val answers =resultsViewModel.answers


    Scaffold(
        containerColor = white,
        topBar = {
            CustomTopBar(
                title = "Answers" ,
                showNavigationIcon = true ,
                navController = navController,
            )
        }
    ) {


        innerPadding ->
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxSize().padding(22.dp).padding(top = 80.dp) ,
//            verticalArrangement = Arrangement.Center
//        ) {
//            items(10){
//                    index -> CustomSingleAnswerList(
//"Select the correctly punctuated sentence."
//                    )
//            }
//        }
    }

}

@Preview
@Composable
private fun AnswersScreenPreview() {
    AnswersScreen(navController = NavController(LocalContext.current))
}


@Composable
fun CustomAnswerItem(
 answer:String,
 selectedCorrect:Boolean= false
 ,
 selectedError:Boolean = false,
 selected: Boolean = false,
 ) {
    Surface(
        color =if(selectedCorrect) lightGreen else if(selectedError) lightRed else whiteBlue,
        shape = CircleShape.copy(all = CornerSize(12)) ,
        border = BorderStroke(1.dp, if(selectedError) error else if(selectedCorrect) success else whiteBlue),
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)  ,
            verticalAlignment = Alignment.CenterVertically,
        ){
            RadioButton(
                colors = RadioButtonDefaults.colors(
                selectedColor =if(selectedError) error else success,
                unselectedColor = primaryColor),
                selected = selected,
                onClick=  null, )
            CustomWidth(10.0)
                Text(answer, style = MaterialTheme.typography.titleMedium)
        }
    }
}


@Composable
fun CustomSingleAnswerList(
    question: String,
) {
    Surface(
        modifier = Modifier.height(320.dp).padding(bottom = 22.dp),
        shadowElevation = 8.dp,
        color = white,
        shape = CircleShape.copy(all = CornerSize(4)) ,
        border = BorderStroke(1.dp, whiteBlue),
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(question,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W500 ,
                    fontSize = 18.sp,
                )
            )
            CustomHeight(10.0)
            LazyColumn(
                userScrollEnabled = false

            ) {
                items(4){
                        item ->
                    CustomAnswerItem(
                        answer = "Answer",
                    )
                }

            }


        }}
    
}