package com.yeditepe.weekthreesectionone.functions

import android.text.TextUtils.replace

fun main(){
    val my_list=listOf("engin","ahmet","ezgi","melih")
    val my_lamba: (Int,Int)->Int = {a:Int,b: Int->a+b}
    //call your higher order function
    println(computation(5,12,my_lamba))
    //call a function reference in HOF
    println(computation(15,5,::sum))
    //LAST PARAMETER CALL SYNTAX
    println(computation(12,6){a: Int,b: Int->a*b})
    //again another calll function reference
    val sentence="cok mu cok guzel bir hava var bugun";
    val word="cok"
    val filtered_list= my_list.filter {it[0]=='e' }
    println("Filtered List: $filtered_list")

  println(textManipulator(sentence,word,::findAndDelete))
    println(textManipulator(sentence, word){
            str1:String,str2: String->str1.replace(str2," ")})
}

fun computation(number1: Int, number2: Int, f: (Int,Int)->Int): Int{
    return f(number1,number2)
}

fun sum(number1: Int, number2: Int):Int {
    return number1+ number2
}

fun textManipulator(sentence: String,
                    word: String,
                    manipulator: (String,String)->String): String{
    return manipulator(sentence,word)
}


fun findAndDelete(sentence:String, word:String):String{
    return sentence.replace(word," ")
}

