package com.example.myapplication.features.results.presentation.componenets

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.red


@Composable
fun CorrectAndInCorrectInfo(
    correct:Int,
    inCorrect:Int
) {

    Column(
        horizontalAlignment = Alignment.Start,
    ) {
        CustomResultItem(
            title = "Correct" ,
            color = primaryColor ,
            value = "$correct"
        )
        CustomHeight(12.0)
        CustomResultItem(
            title = "Incorrect" ,
            color = red ,
            value = "$inCorrect"
        )

    }
}
