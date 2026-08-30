package com.example.myapplication.core.sharedCompnents
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    navController: NavController,
    title: String?,
    actions: @Composable RowScope.() -> Unit = {},
    showNavigationIcon: Boolean = true,


    ) {
    TopAppBar(
        actions =actions ,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = white
        ) ,
        navigationIcon = {
         if(showNavigationIcon){
             Icon(
                 modifier = Modifier.clickable{
                     navController.popBackStack()
                 } ,
                 imageVector = Icons.Default.ArrowBack, contentDescription = null
             )
         }
        },
        title = {
            Text(text = title?:"")
        }
    )
}