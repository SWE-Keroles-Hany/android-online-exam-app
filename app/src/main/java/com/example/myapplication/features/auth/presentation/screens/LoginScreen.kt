package com.example.myapplication.features.auth.presentation.screens
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.core.navigation.Screen
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.core.sharedCompnents.CustomButton
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.CustomTextField
import com.example.myapplication.core.validation.AppValidation
import com.example.myapplication.features.auth.domain.models.LoginRequest
import com.example.myapplication.features.auth.presentation.viewmodel.AuthViewModel
import com.example.myapplication.ui.theme.black
import com.example.myapplication.ui.theme.grey
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.white
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(
    // ====
    viewModel: AuthViewModel =koinViewModel() ,
    navController: NavController) {
    val appValidation = AppValidation()

    val loginState by viewModel.loginState.collectAsState()
    val context = LocalContext.current
    val isLoading = loginState is NetworkResult.Loading

    var emailError by remember {
        mutableStateOf<String?>(null)
    }

    var passwordError by remember {
        mutableStateOf<String?>(null)
    }
    var remeberMe by remember {
        mutableStateOf(false)
    }
    var visiblePassword by remember {
        mutableStateOf(false)
    }


    LaunchedEffect(loginState) {
        when (val state = loginState) {


            is NetworkResult.Success -> {
                navController.navigate(Screen.HomeScreen.route)
            }

            is NetworkResult.Error -> {
                Toast.makeText(context,
                    state.message,
                    Toast.LENGTH_LONG).show()
            }

            null -> Unit
            else -> {}
        }
    }

       val emailState = rememberTextFieldState()
        val passwordState = rememberTextFieldState()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(22.dp)
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
            errorMessage = emailError,
            isError = emailError!=null,
            state = emailState,
            modifier = Modifier.fillMaxWidth(),
            label = "Enter Your Email",
            leadingIcon = {
                // => <=
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
            isPasswordField = true,
            errorMessage = passwordError,
            isError = passwordError!=null,
            state = passwordState,
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
                checked = remeberMe , onCheckedChange ={
                    remeberMe = it
                } ,
            )
            Text("Remember me" ,
            style = MaterialTheme.typography.labelLarge
                )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                "Forgot Password?" ,
                style = MaterialTheme.typography.labelLarge.copy(
                    color = black,
                    textDecoration = TextDecoration.Underline
                ) ,
                modifier = Modifier.clickable {}

            )
        }
        CustomHeight(16.0)
        CustomButton(
            onClick = {
                 emailError = appValidation.validateEmail(emailState.text.toString())
                 passwordError = appValidation.validatePassword(passwordState.text.toString())
                if(emailError == null && passwordError == null ){
                    viewModel.login(
                        LoginRequest(
                            email =emailState.text.toString() ,
                            password = passwordState.text.toString()
                        )
                    )
                }

            } ,
            title = "Login" ,
            bgColor =primaryColor ,
            borderColor = white ,
            titleColor = white

        )

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
                modifier = Modifier.clickable {
                    navController.navigate(Screen.SignUpScreen.route)
                }

                )
        }
        if(isLoading){
            CircularProgressIndicator(color = primaryColor)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, apiLevel = 35)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(navController = NavController(LocalContext.current))
    
}





