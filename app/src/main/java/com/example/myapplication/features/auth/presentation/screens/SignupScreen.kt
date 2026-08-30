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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.rememberTextFieldState
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.core.navigation.Screen
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.core.sharedCompnents.CustomButton
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.CustomTextField
import com.example.myapplication.core.validation.AppValidation
import com.example.myapplication.features.auth.domain.models.SignupRequest
import com.example.myapplication.features.auth.presentation.viewmodel.AuthViewModel
import com.example.myapplication.ui.theme.grey
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.white
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SignUpScreen(modifier: Modifier = Modifier, navController: NavController ,
                 viewModel: AuthViewModel=koinViewModel()
) {
    val appValidation = AppValidation()
    val userNameState = rememberTextFieldState()
    val firstNameState = rememberTextFieldState()
    val lastNameState = rememberTextFieldState()
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()
    val rePasswordState = rememberTextFieldState()
    val phoneState = rememberTextFieldState()
    // ===========
    var nameError by remember {
        mutableStateOf<String?>(null)
    }
    var emailError by remember {
        mutableStateOf<String?>(null)
    }
    var passwordError by remember {
        mutableStateOf<String?>(null)
    }
    var phoneNumberError by remember {
        mutableStateOf<String?>(null)
    }

    val signupState by viewModel.signupState.collectAsState()
    val context = LocalContext.current
    val isLoading = signupState is NetworkResult.Loading
    LaunchedEffect(signupState) {

        when (val state = signupState) {

            is NetworkResult.Success -> {
                Toast.makeText(
                        context,
                "Signup Success",
                Toast.LENGTH_SHORT
                ).show()
                navController.navigate(Screen.LoginScreen.route)
                viewModel.clearSignupState()
            }

            is NetworkResult.Error -> {
                Toast.makeText(
                    context,
                    state.message,
                    Toast.LENGTH_SHORT
                ).show()
                viewModel.clearSignupState()
            }
            null -> Unit
            else -> {}
        }
    }
    Column(
        modifier = modifier
    )
    {
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
            Text("Create an Account",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                )

            )
            CustomHeight(12.0)
            // user name
            CustomTextField(
                isError = nameError!=null,
                errorMessage = nameError,
                state = userNameState,
             modifier = Modifier.fillMaxWidth(),
                label = "Enter User Name",
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.person_icon) ,
                        contentDescription = null ,
                        tint =primaryColor,
                    )

                }
            )
            CustomHeight(6.0)
            Row(
                modifier = Modifier.fillMaxWidth(),
                ) {
                CustomTextField(
                    isError = nameError!=null,
                    errorMessage = nameError,
                    state = firstNameState,
                    modifier = Modifier.weight(1f),
                    label = "First Name",
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.person_icon) ,
                            contentDescription = null ,
                            tint =primaryColor,
                        )

                    }
                )
               Spacer(modifier = Modifier.width(6.dp))
                CustomTextField(
                    isError = nameError!=null,
                    errorMessage = nameError,

                    state = lastNameState,
                    modifier = Modifier.weight(1f),
                    label = "Last Name",
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.person_icon) ,
                            contentDescription = null ,
                            tint =primaryColor,
                        )

                    }
                )
            }
            CustomHeight(6.0)
            // Email
            CustomTextField(
                isError = emailError!=null,
                errorMessage = emailError,
                state = emailState,
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
            CustomHeight(6.0)

            // Password
            CustomTextField(
                isPasswordField = true,
                isError = passwordError!=null ,
                errorMessage = passwordError,
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
            CustomHeight(6.0)

            CustomTextField(
                isPasswordField = true ,
                isError = passwordError!=null,
                errorMessage = passwordError,

                state = rePasswordState,
                modifier = Modifier.fillMaxWidth(),
                label = "Confirm Password",
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
            CustomHeight(6.0)

            CustomTextField(
                isError = phoneNumberError!=null,
                errorMessage = phoneNumberError,
                state = phoneState,
                modifier = Modifier.fillMaxWidth(),
                label = "Enter Your Phone Number",
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.local_phone_icon) ,
                        contentDescription = null ,
                        tint =primaryColor,
                    )
                              } ,

            )

            CustomHeight(16.0)
            CustomButton(
                onClick = {
                  emailError= appValidation.validateEmail(emailState.text.toString())
                    nameError = appValidation.validateName(userNameState.text.toString())
                    phoneNumberError = appValidation.validatePhoneNumber(phoneState.text.toString())
                    passwordError = appValidation.validatePassword(passwordState.text.toString())
                    if(emailError == null && passwordError == null && nameError == null){

                        viewModel.signup(
                            signupRequest = SignupRequest(
                                username = userNameState.text.toString(),
                                firstName = firstNameState.text.toString() ,
                                lastName = lastNameState.text.toString() ,
                                email = emailState.text.toString(),
                                password = passwordState.text.toString() ,
                                phone =phoneState.text.toString(),
                                rePassword =rePasswordState.text.toString()
                            )
                        )

                    }

                },
                title = "Sign up" , bgColor = primaryColor , titleColor = white , borderColor = white)
            CustomHeight(8.0)

            Row() {
                Text(
                    "Already have an account? " ,
                    style = MaterialTheme.typography.labelLarge,


                    )
                Text(
                    "Login" ,
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = primaryColor ,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline ,
                    ),
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.LoginScreen.route)
                    }

                )

                if(isLoading){
                CircularProgressIndicator(color = primaryColor)
            }
        }
    }
}}

