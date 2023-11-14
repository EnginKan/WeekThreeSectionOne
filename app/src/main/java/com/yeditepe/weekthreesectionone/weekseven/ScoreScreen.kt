package com.yeditepe.weekthreesectionone.weekseven

import android.util.Log
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yeditepe.weekthreesectionone.R
import com.yeditepe.weekthreesectionone.ui.theme.WeekThreeSectionOneTheme


@Composable
fun TeamScore(score: String ="0",
              teamname:String,
              onPressed:()->Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.teamA,teamname))
        Text(text = score,
        style = MaterialTheme.typography.bodyMedium
        )
        Button(onClick = onPressed) {
            Text(
                text=  stringResource(id =R.string.IncrementButton)
            )
        }
    }
}
@Composable
fun TeamCard(scoreCardModel :ScoreViewModel= viewModel()){
    val scoreUIState by scoreCardModel.scoreCard.collectAsState()
    Column(verticalArrangement =Arrangement.Center
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row (
                horizontalArrangement = Arrangement.Center
                    ){
                TeamScore(teamname = scoreUIState.teamname1,
                    score = scoreUIState.scoreTeam1.toString(),
                onPressed ={ scoreCardModel.updateScore(true)
                            Log.d("TeamAUpdate",scoreUIState.scoreTeam1.toString())})
                Spacer(modifier = Modifier.padding(20.dp))
                TeamScore(teamname = scoreUIState.teamName2,
                score = scoreUIState.scoreTeam2.toString()) {
                    scoreCardModel.updateScore(false)
                    Log.d("TeamBUpdate",scoreUIState.scoreTeam2.toString())
                }

            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun TeamCardPreview(){

    WeekThreeSectionOneTheme {
        TeamCard()

    }
}