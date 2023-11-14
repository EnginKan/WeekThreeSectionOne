package com.yeditepe.weekthreesectionone.composableexamples.SingleChoiceQuestion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yeditepe.weekthreesectionone.R
import com.yeditepe.weekthreesectionone.ui.theme.WeekThreeSectionOneTheme


data class Answer(val image_id : Int, val text: String)
@Composable
fun QuestionTemplate(data: List<Answer>){
    var selectedAnswer by rememberSaveable {
        mutableStateOf<Answer?>(null)

    }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text="Question 1",
            style=MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.padding(vertical=16.dp))
        
        data.forEach { 
            answer->
            SingleOption(selected= (selectedAnswer==answer),
                answer = answer,
            onPressed = {selectedAnswer=answer})
        }
        
    }
    
}
@Composable
fun SingleOption(selected: Boolean ,
                 answer: Answer,onPressed: ()->Unit){

    Surface(modifier = Modifier.background(color =if(selected) MaterialTheme.colorScheme.onPrimaryContainer
    else MaterialTheme.colorScheme.primaryContainer
    )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = answer.image_id),
                contentDescription = "",
                modifier = Modifier.clip(MaterialTheme.shapes.small)
            )
            Text(
                text = answer.text,
                modifier = Modifier.padding(end = 8.dp),
                style = MaterialTheme.typography.bodySmall
            )
            RadioButton(selected = selected,
                onClick = onPressed)

        }
    }

}

@Preview
@Composable
fun SingleOptionPreview(){
    WeekThreeSectionOneTheme {
        //val answer = Answer(R.drawable.answer_icon_background,"Answer 1")
        //SingleOption(answer =answer )
        QuestionTemplate(data = DataProvider.giveOptions())
    }
}