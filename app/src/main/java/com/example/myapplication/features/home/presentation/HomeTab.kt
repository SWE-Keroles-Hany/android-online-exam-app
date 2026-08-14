package com.example.myapplication.features.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.CustomWidth
import com.example.myapplication.features.home.presentation.componenets.CustomSubject
import com.example.myapplication.features.home.presentation.componenets.SimpleSearchBar
import com.example.myapplication.ui.theme.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun HomeTab(modifier: Modifier = Modifier) {
    val subjectList = listOf<SubjectItem>(
        SubjectItem("Language" , R.drawable.language),
        SubjectItem("Math" , R.drawable.math),
        SubjectItem("Art" , R.drawable.art),
        SubjectItem("Science" , R.drawable.science),

        )
    var textFieldState by remember { mutableStateOf(TextFieldState()) }
        Column(

        Modifier.fillMaxSize().padding(22.dp)
    ) {
         CustomHeight(16.0)
            // label
        Text("Survey" ,
          style = MaterialTheme.typography.titleLarge.copy(
              color = primaryColor ,
              fontWeight = FontWeight.W500))

            // search text field
            CustomHeight(16.0)
            SimpleSearchBar(
                textFieldState = textFieldState,
            )
            CustomHeight(40.0)
            Text("Browse by subject" ,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500))
            CustomHeight(24.0)

            // list of items
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(subjectList) { item ->

                    CustomSubject(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp).clickable {

                            },
                        icon = item.icon,
                        title = item.title
                    )
                }
            }
           
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeTabPreview() {
    HomeTab()
}

