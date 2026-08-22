package com.example.myapplication.features.exams.presentation.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.core.navigation.Screen
import com.example.myapplication.core.sharedCompnents.CustomButton
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.CustomTopBar
import com.example.myapplication.core.sharedCompnents.CustomWidth
import com.example.myapplication.ui.theme.grey
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.white

@Composable
fun ExamInstructionsScreen(
    title:String ,
    duration: Int,
    numOfQuestions:Int,
    examId : String,
    modifier: Modifier = Modifier , navController: NavController) {
    var showDialog by remember {
        mutableStateOf(false)
    }
    val items = listOf(
        "Read all questions carefully before answering.",
        "Answer all questions clearly and write your answers in the correct space",
        "Manage your time and do not spend too much time on one question" ,
        "Do not use mobile phones or communicate with other students during the exam"
        )

    Scaffold(
        containerColor = white,
        topBar = {
            CustomTopBar(
                 navController = navController,title = null )
        }
    ) {
        innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(22.dp)

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),

            ) {
                Image(
                    painter = painterResource(R.drawable.instruction),
                    contentDescription = null ,
                    modifier = Modifier.size(60.dp)
                )
                CustomWidth(10.0)
                Text(title , style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.W500 ,
                ))
                Spacer(modifier = Modifier.weight(1f))
                Text("$duration Minutes" , style = MaterialTheme.typography.titleMedium.copy(
                    color = primaryColor,
                ))
            }
            CustomHeight(12.0)

            Text("$numOfQuestions Questions" , style = MaterialTheme.typography.titleMedium.copy(
                color = grey,
            ))
            CustomHeight(12.0)
            HorizontalDivider(color = grey)
            CustomHeight(12.0)
            Text("Instructions" , style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.W500 ,
            ))
            CustomHeight(12.0)

            Text(
                style = MaterialTheme.typography.titleMedium.copy(
                        color = grey,
                ),
                text = buildAnnotatedString {
                    withBulletList {
                        items.forEach { item ->
                            withBulletListItem {
                                append(item)
                                append("\n")
                            }
                        }
                    }
                }
            )

            CustomHeight(50.0)
            CustomButton(bgColor = primaryColor , title = "Start" ,
                onClick = {
                    showDialog = true
            })
            if(showDialog){
                CustomDialog(
                    title ="Ready ?",
                    subTitle = "Are you ready to start the exam",
                    onConfirm = {
                        showDialog = false
                    navController.navigate(Screen.QuestionsScreen.route + "/$examId"+"/$numOfQuestions"+"/$duration")

                }, onDismiss = {
                    showDialog =false
                    })
            }


        }
    }
}



@Composable
fun CustomDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit ,
    title: String,
    subTitle: String
) {
    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        title = {
            Text(title, style = MaterialTheme.typography.titleMedium)
        },
        text = {
            Text(subTitle, style = MaterialTheme.typography.titleSmall)
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm()
                }
            ) {
                Text("Yes")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text("Cancel")
            }
        }
    )
}