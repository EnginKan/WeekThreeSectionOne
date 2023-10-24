package com.yeditepe.weekthreesectionone

import android.content.res.Configuration
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yeditepe.weekthreesectionone.ui.theme.GeceOnizleme
import com.yeditepe.weekthreesectionone.ui.theme.GunduzOnizleme
import com.yeditepe.weekthreesectionone.ui.theme.WeekThreeSectionOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

data class Answer(val text: String, val image: Int)
@Composable
fun SurveyAnswer(answer: Answer ){
    var selected = remember {
        mutableStateOf(false)
    }
    Row(modifier= Modifier.fillMaxWidth()
        .padding(all=5.dp)
        .background(color = MaterialTheme.colorScheme.secondary,
            shape= RoundedCornerShape(5.dp)),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically

    ){
        Image(painter = painterResource(id = answer.image) ,
            modifier = Modifier.clip(MaterialTheme.shapes.small),
            contentDescription ="" )
        Text(text = answer.text )
        RadioButton(selected = selected.value,
            onClick = {
                selected.value =!selected.value
            })
    }
}
@Composable
fun SingleChoiceQuestion(question_text: String, answers: List<Answer>){

    Column(
        modifier=Modifier.background(color=MaterialTheme.colorScheme.tertiary),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text=question_text,
            fontSize = 20.sp,
            color = Color.White
        )
        answers.forEach {
            answer->SurveyAnswer(answer = answer )
        }
    }
}

/*
@Preview(showSystemUi = true,
uiMode=Configuration.UI_MODE_NIGHT_YES, showBackground = true,
    device = "spec:parent=pixel_5,orientation=landscape"
)
*/
@GunduzOnizleme
/*
@Preview(name = "ligth_mode",

    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true, showSystemUi = true
)
*/
@GeceOnizleme
@Composable
fun PreviewSurveytAnswer(){
    val answers =listOf(Answer("This is answer 1",
        R.drawable.ic_launcher_background),
        Answer("This is answer 2",
            R.drawable.ic_launcher_background),
        Answer("This is answer 3",
            R.drawable.ic_launcher_background))
    /*val answer= Answer("This is answer",
        R.drawable.ic_launcher_background)*/
    WeekThreeSectionOneTheme {
     Surface{
        SingleChoiceQuestion(question_text ="This is our question" , answers =answers )
         }
        
    }

}

