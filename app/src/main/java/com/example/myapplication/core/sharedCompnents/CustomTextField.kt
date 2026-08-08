package com.example.myapplication.core.sharedCompnents

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(

    leadingIcon:@Composable (() -> Unit)? = null,
    trailingIcon:@Composable (()->Unit)?=null,
    label :  String,
    modifier: Modifier = Modifier,
    isPasswordField: Boolean = false,

    ) {
    OutlinedTextField(
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        contentPadding = PaddingValues(vertical = 16.dp , horizontal = 8.dp),
        shape = RoundedCornerShape(8.dp),
        label = {
            Text(label)
        },
        state = rememberTextFieldState(initialText = ""),
        modifier = modifier,
    )
}
// preview more
// android career is best