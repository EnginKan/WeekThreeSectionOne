package com.yeditepe.weekthreesectionone.weekseven

import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ScoreViewModel(): ViewModel() {

    private val _scoreCard = MutableStateFlow(
        ScoreCard(teamname1 = "A",teamName2 = "B",
        scoreTeam1 = 0, scoreTeam2 = 0)
    )
    val scoreCard : StateFlow<ScoreCard>
        get() = _scoreCard.asStateFlow()

    fun updateScore(isteamA: Boolean){
        _scoreCard.update {
        if(isteamA)
            it.scoreTeam1.inc()
        else
            it.scoreTeam2.inc()
    }
}