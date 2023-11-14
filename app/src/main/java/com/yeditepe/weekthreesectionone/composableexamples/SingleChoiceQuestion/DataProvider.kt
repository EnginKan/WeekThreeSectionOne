package com.yeditepe.weekthreesectionone.composableexamples.SingleChoiceQuestion

import com.yeditepe.weekthreesectionone.R

object DataProvider {
    val data= mutableListOf<Answer>()
    fun giveOptions():List<Answer>{
        for(i in 1..4)
        data.add(Answer(R.drawable.answer_icon_foreground,"Answer "+i))
        return data
    }

}