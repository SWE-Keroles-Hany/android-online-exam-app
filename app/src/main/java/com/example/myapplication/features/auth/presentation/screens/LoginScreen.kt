package com.example.myapplication.features.auth.presentation.screens

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.core.sharedCompnents.CustomButton
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.CustomTextField
import com.example.myapplication.ui.theme.black
import com.example.myapplication.ui.theme.grey
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.red
import java.time.format.TextStyle

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(22.dp)
    ) {
        Icon(
            tint = primaryColor,
            painter = painterResource(R.drawable.menu_book_icon), 
            contentDescription = null ,
            modifier = Modifier.size(100.dp),
        )
        CustomHeight(16.0)
        // Text Welcome Back
        Text("Welcome Back",

            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.SemiBold,
            )

            )
        CustomHeight(16.0)

        // Email
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "Enter Your Eamil",
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.email_icon) ,
                    contentDescription = null ,
                    tint =primaryColor,
                )

            }
        )
        CustomHeight(8.0)

        // Password
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "Enter Your Password",
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.password_icon) ,
                    contentDescription = null ,
                    tint =primaryColor,
                )

            } ,
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.visibility_icon) ,
                    contentDescription = null ,
                    tint = grey,
                )

            }
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = false , onCheckedChange ={} ,
            )
            Text("Remember me" ,
            style = MaterialTheme.typography.labelMedium
                )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                "Forgot Password?" ,
                style = MaterialTheme.typography.labelMedium.copy(
                    color = black,
                    textDecoration = TextDecoration.Underline
                ) ,
                modifier = Modifier.clickable {}

            )
        }
        CustomHeight(16.0)
        CustomButton(title = "Login" , bgColor = grey)
        CustomHeight(8.0)

        Row() {
            Text(
                "Don't have an account? " ,
                style = MaterialTheme.typography.labelLarge,


            )
            Text(
                "Sign up" ,
                style = MaterialTheme.typography.labelLarge.copy(
                    color = primaryColor ,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline ,
                ),
                modifier = Modifier.clickable {  }

                )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen()

}