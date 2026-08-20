package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import com.example.myapplication.core.navigation.AppNavHost
import com.example.myapplication.features.auth.presentation.screens.LoginScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.lang.reflect.Modifier
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme{
                Scaffold(){
                    innerPadding ->
                    AppNavHost()
                }
            }
        }
    }
}
/*
1- Di - Interceptor ==> Flow
2- Data Store For Token
3- how implement Exams screens
4-

 */