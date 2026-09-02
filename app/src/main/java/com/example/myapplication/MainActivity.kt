package com.example.myapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import com.example.myapplication.core.navigation.AppNavHost
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                Scaffold { innerPadding ->
                    AppNavHost()
                }
            }
        }
    }
}

/*
* Refactor *
- refactor naming components ( answers , results , data Sources )
- rev ( di , retrofit )
----------------------
* Tasks *
- answers screen results
- result tab
- profile
- token storage , keep loggedIn
- Icon/name/splash
*
*/