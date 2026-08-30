package com.example.myapplication.core.sharedCompnents
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    bgColor : Color,
    titleColor : Color ,
    borderColor : Color ,
    title : String,
    onClick:  () -> Unit,
    modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {

        Button(

            colors = ButtonDefaults.buttonColors(
                containerColor = bgColor
            ),
            contentPadding = PaddingValues(12.dp),
            modifier = Modifier.fillMaxWidth().border(1.dp, borderColor, shape = CircleShape) ,
            onClick =onClick ,
        ) {
            Text(title, fontSize = 20.sp, color = titleColor)


        }
    }
}