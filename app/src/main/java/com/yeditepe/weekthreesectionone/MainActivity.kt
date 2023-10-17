package com.yeditepe.weekthreesectionone

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yeditepe.weekthreesectionone.ui.theme.WeekThreeSectionOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun Mytext(str: String){

        Text(
            text = str,
            fontSize = 4.sp,
            color = Color.Black

        )


}
@Preview(name="white mode")
@Preview(uiMode= Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
name="nigth mode")
@Composable
fun Mytextpreview(){
    Mytext(str = "Hello jetpack Compose")
}



