package com.yeditepe.weekthreesectionone.classesandobjects

class Student {

    val name: String="Name"
    var gpa: Double = -1.0
}
class StudentV1(name : String, gpa: Double){
    val name = name
    var gpa =gpa
}

class StudentV2(val name: String, var gpa: Double)

class StudentV3(val name: String ="student", var gpa: Double= -1.0){

    init {
        println("Name: $name GPA: $gpa")
    }
}

open class StudentV4(val name: String, var gpa: Double){
    var program: String ="-"
        get() = field.uppercase()
        set(value) {
            field=value.uppercase()
        }
    var student_id: String =""
        set(value){
            field=value
            println("Student ID change to $field")
        }
    //secondary constructor
    constructor(name:String, gpa: Double,program:String): this(name,gpa){
        this.program=program
    }
}

class StudentV5(var name: String, var program: String){

    companion object{
        val universtiy: String = "yeditepe"
        fun giveInfo(){
            println("${universtiy.uppercase()}")
        }
    }

    override fun toString(): String {
        return "Name: $name Dep: $program"
    }
}

data class StudentV6(var name: String, var program: String)

class GraduateStudent(name:String,
                      gpa: Double,
                      val advisor: String): StudentV4(name=name,gpa=gpa)

