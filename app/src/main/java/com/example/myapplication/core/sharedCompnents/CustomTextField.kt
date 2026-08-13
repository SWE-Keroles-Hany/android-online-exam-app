package com.example.myapplication.core.sharedCompnents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.grey

@Composable
fun CustomTextField(
    isPasswordField : Boolean = false,
    isError: Boolean = false,
    state : TextFieldState,
    errorMessage: String? = null,
    leadingIcon:@Composable (() -> Unit)? = null,
    trailingIcon:@Composable (()->Unit)?=null,
    label :  String,
    modifier: Modifier = Modifier,
    ) {
    var isVisiable by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        isError = isError,
        state = state,
        supportingText = { if (errorMessage != null) { Text(errorMessage) } },
        leadingIcon = leadingIcon,
        trailingIcon =
            {
                if(isPasswordField)
                Icon(
                    modifier = Modifier.clickable {
                        isVisiable= !isVisiable ;
                    } ,
                    painter = painterResource(

                        if(isVisiable) R.drawable.visibility_icon else R.drawable.visibility_off_icon) ,
                    contentDescription = null ,
                    tint = grey,
                )
                else null
            }
        ,
        contentPadding = PaddingValues(vertical = 16.dp , horizontal = 8.dp),
        shape = RoundedCornerShape(8.dp),
        label = {
            Text(label)
        },
        modifier = modifier,
        )
}
