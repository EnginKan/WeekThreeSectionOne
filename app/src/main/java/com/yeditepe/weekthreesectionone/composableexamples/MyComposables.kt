package com.yeditepe.weekthreesectionone.composableexamples

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yeditepe.weekthreesectionone.ui.theme.WeekThreeSectionOneTheme

@Composable
fun MyButton(isClicked: MutableState<Boolean>,
    modifier: Modifier=Modifier, onPressed: ()->Unit){

    var text_in_button= if (isClicked.value == true) "Not Saved" else " Not Saved"
    var button_color = if( isClicked.value== true ) Color.Blue else Color.Red
    Button(modifier = modifier,
        colors = ButtonDefaults.outlinedButtonColors(button_color),

        onClick =onPressed) {
        Text(text = text_in_button,
        color =Color.White)

    }
}
@Composable
fun MyTest(){


    var text= rememberSaveable { mutableStateOf("")}
    var isClicked= rememberSaveable {
        mutableStateOf(true)}
    var second_text=rememberSaveable { mutableStateOf("")}

    Surface(modifier = Modifier.background(MaterialTheme.colorScheme.surface)){
    Column{
        BasicTextField(value = text.value, onValueChange ={
            text.value = it } )
        Text(text = second_text.value)
        MyButton(isClicked=isClicked,
            onPressed = {
                second_text.value=text.value
                isClicked.value=!isClicked.value
            })
    }
}
}

@Composable fun MyCard(){
    Card(){
        Text(text = "My Text")
    }
}
@Preview()
@Composable
fun MyButtonPreview(){
    WeekThreeSectionOneTheme {
        Column {
            MyTest()
        }

    }

}