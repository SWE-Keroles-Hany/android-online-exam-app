package com.example.myapplication.features.exams.presentation.Componenets
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.CustomWidth
import com.example.myapplication.ui.theme.grey
import com.example.myapplication.ui.theme.primaryColor

@Composable
fun CustomExamItem(
    questionsNumber:Int,
    title : String,
    minutes: Int?,
    from : String ,
    to : String,
    onClick: () -> Unit
)
{
        Row(
            modifier = Modifier.fillMaxWidth().shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(12.dp)
            )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(12.dp)
                ).padding(16.dp).clickable{
                    onClick()
                }
            ,
            verticalAlignment = Alignment.CenterVertically,
        ){

            Image(
                painter = painterResource(R.drawable.exam_icon),
                modifier = Modifier.height(60.dp),
                contentDescription = null
                )
            CustomWidth(16.0)
            Column(
                modifier = Modifier.fillMaxWidth(),
                ) {
                CustomHeight(8.0)
                Row(
                   modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(title , style = MaterialTheme.typography.titleMedium)
                    Text("$minutes Minutes" , style = MaterialTheme.typography.titleSmall.copy(
                        color = primaryColor
                    ))
                }
                Text("$questionsNumber Questions" , style = MaterialTheme.typography.titleMedium.copy(
                    color = grey
                ))
                CustomHeight(16.0)
                Text("From :$from   To: $to" , style = MaterialTheme.typography.titleMedium)


            }
        }
    }


