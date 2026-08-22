package com.example.myapplication.features.exams.presentation.Componenets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheetDefaults.properties
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.myapplication.R
import com.example.myapplication.core.sharedCompnents.CustomButton
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.red
import com.example.myapplication.ui.theme.white
import java.util.Properties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeOutDialog(onClick: () -> Unit) {

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = white,
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 10.dp,
    ) {
        AlertDialog(
            onDismissRequest = {}
        ){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = androidx.compose.ui.Modifier.fillMaxWidth()

            ) {
                Image(
                    painter = painterResource(R.drawable.timeout),
                    contentDescription = null,

                    )
                CustomHeight(15.0)
                Text("Time Out!!" , style = MaterialTheme.typography.titleLarge.copy(
                    color = red ,
                ))
                CustomHeight(20.0)
                CustomButton(bgColor = primaryColor , title = "View Score" ,
                    onClick = {
                        onClick()
                    })

            }
        }
    }
}