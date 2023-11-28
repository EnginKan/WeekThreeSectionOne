package com.yeditepe.weekthreesectionone

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import com.yeditepe.weekthreesectionone.ui.theme.WeekThreeSectionOneTheme

class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            WeekThreeSectionOneTheme {
                Column {
                    Text(text = "Activity Two")
                    Button(onClick = {
                        Intent(this@SecondActivity,MainActivity::class.java)
                            .also {
                                startActivity(it);
                            }
                    }) {
                        Text(text = "Main Activity")

                    }
                }

            }

        }
    }
}