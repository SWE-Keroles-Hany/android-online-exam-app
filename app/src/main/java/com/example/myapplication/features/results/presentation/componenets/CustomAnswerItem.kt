package com.example.myapplication.features.results.presentation.componenets
import android.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.core.sharedCompnents.CustomWidth
import com.example.myapplication.features.exams.domain.models.Answer
import com.example.myapplication.ui.theme.error
import com.example.myapplication.ui.theme.lightGreen
import com.example.myapplication.ui.theme.lightRed
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.success
import com.example.myapplication.ui.theme.whiteBlue

@Composable
fun CustomAnswerItem(
    answer: Answer,
    correctAnswer : String,
    wrongAnswer : String?,
) {
    val selectedError = wrongAnswer !=null
    Surface(
        color =if( correctAnswer==answer.key) lightGreen else if(selectedError && wrongAnswer==answer.key) lightRed else whiteBlue,
        shape = CircleShape.copy(all = CornerSize(12)) ,
        border = BorderStroke(1.dp, if(selectedError && wrongAnswer==answer.key) error else if(correctAnswer==answer.key) success else whiteBlue),
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            RadioButton(
                colors = RadioButtonDefaults.colors(
                    selectedColor =if(selectedError && wrongAnswer==answer.key) error else success,
                    unselectedColor = primaryColor

                ),
                selected = (correctAnswer==answer.key) || ( wrongAnswer==answer.key),
                onClick=  null,
                )
            CustomWidth(10.0)
            Text(answer.answer, style = MaterialTheme.typography.titleMedium)
        }
    }



}
