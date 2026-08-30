package com.example.myapplication.features.results.presentation.componenets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.primaryColor


@Composable
fun CustomCircleProgress(
    percentage: String, progress:Float) {

    Box(
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(
            gapSize = 5.dp,
            progress = { progress },
            modifier = Modifier
                .padding(16.dp)
                .size(120.dp),
            color = primaryColor,
            strokeWidth = 7.dp,
            trackColor = ProgressIndicatorDefaults.circularColor.copy(red = 1F , green = 0F , blue = 0F),
            strokeCap = ProgressIndicatorDefaults.CircularDeterminateStrokeCap,
        )
        Text(percentage, style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold ,
        ))
    }

}