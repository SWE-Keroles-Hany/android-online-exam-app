package com.example.myapplication.features.exams.presentation.Componenets

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.myapplication.ui.theme.success
import kotlinx.coroutines.delay

@SuppressLint("DefaultLocale")
@Composable
fun CountdownTimer(
    initialMinutes: Int
) {
    var remainingSeconds by remember {
        mutableIntStateOf(initialMinutes * 60)
    }

    LaunchedEffect(Unit) {
        while (remainingSeconds > 0) {
            delay(1000L)
            remainingSeconds--
        }
    }

    val minutes = remainingSeconds / 60
    val seconds = remainingSeconds % 60

    Text(
        text = String.format("%02d:%02d", minutes, seconds),
        style = MaterialTheme.typography.titleMedium.copy(
            color = success,
        )
    )
}

