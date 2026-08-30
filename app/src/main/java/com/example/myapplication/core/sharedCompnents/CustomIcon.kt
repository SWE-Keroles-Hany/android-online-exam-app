package com.example.myapplication.core.sharedCompnents
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun CustomIcon(
    id:Int,
    contentDescription:String,
    modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(id),
        contentDescription = contentDescription)

};
