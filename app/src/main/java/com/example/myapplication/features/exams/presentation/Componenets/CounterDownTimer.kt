package com.example.myapplication.features.exams.presentation.Componenets

import android.R.attr.title
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.myapplication.core.sharedCompnents.CustomButton
import com.example.myapplication.features.exams.presentation.Screens.CustomDialog
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.red
import com.example.myapplication.ui.theme.success
import kotlinx.coroutines.delay
import java.lang.reflect.Modifier

@SuppressLint("DefaultLocale")
@Composable
fun CountdownTimer(
    initialMinutes: Int
) {
    var showTimeOutDialog by remember {
        mutableStateOf(false)
    }
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
    if(remainingSeconds == 0){
        showTimeOutDialog= true
    }

    Text(
        text = String.format("%02d:%02d", minutes, seconds),
        style = MaterialTheme.typography.titleMedium.copy(
            color = success,
        )
    )
    if(showTimeOutDialog){
        TimeOutDialog(
            onClick = {}
        )
    }
}

