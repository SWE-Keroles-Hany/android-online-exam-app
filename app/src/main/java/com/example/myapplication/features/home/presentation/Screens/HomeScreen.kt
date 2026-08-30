package com.example.myapplication.features.home.presentation.Screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.myapplication.features.home.presentation.componenets.HomeTab
import com.example.myapplication.features.home.presentation.componenets.NavItem
import com.example.myapplication.features.profile.presentation.ProfileTab
import com.example.myapplication.features.results.presentation.componenets.ResultsTab
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.white

// nav item , nav item list ,
@Composable
fun HomeScreen( navController: NavController) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    val navItems = listOf<NavItem>(
        NavItem(
            label = "Home",
            icon = Icons.Default.Home,
        ),
        NavItem(
            label = "Result",
            icon = Icons.Default.BarChart,
        ),
        NavItem(
            label = "Profile",
            icon = Icons.Default.Person,
        )
    )

    Scaffold(
        containerColor = white,
        bottomBar = {
         NavigationBar() {
             navItems.forEachIndexed { index, navItem ->
                NavigationBarItem(
                    selected = selectedIndex==index ,
                    label = {Text(navItem.label)} ,
                    icon = {
                        Icon(
                            tint = primaryColor,
                            imageVector = navItem.icon, contentDescription = null
                        )
                    },
                    onClick = {
                        selectedIndex = index
                    } ,

                )

             }
         }

        }
    ) {
        innerPadding ->
        when(selectedIndex){
            0 -> HomeTab(navController = navController)
            1-> ResultsTab()
            2-> ProfileTab()
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}
