package com.example.myapplication.features.exams.presentation.Componenets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.whiteBlue

@Composable
fun QuestionItem(question: String ,onClick: (() -> Unit) , selected: Boolean ) {
    Surface(
        color = whiteBlue,
        shape = CircleShape.copy(all = CornerSize(10)) ,
        modifier = Modifier.padding(bottom = 16.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth()  ,
            verticalAlignment = Alignment.CenterVertically,
        ){
            RadioButton(
                colors = RadioButtonDefaults.colors(
                    selectedColor = primaryColor,
                    unselectedColor = primaryColor,
                ) ,
                selected = selected , onClick=  onClick)
            Text(question ,
                style = MaterialTheme.typography.titleMedium)
        }
    }
}