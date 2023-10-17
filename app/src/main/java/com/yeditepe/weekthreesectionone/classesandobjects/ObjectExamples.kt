package com.yeditepe.weekthreesectionone.classesandobjects

fun main(){

    val student = Student()
    println(student.gpa)
    println(student.name)
    val student2= StudentV1("Engin",2.0)
    println(student2.name)
    println(student2.gpa)
    val student3= StudentV2("Ahmet",3.0)
    println(student3.name)
    println(student3.gpa)
    val student4=StudentV3()
    val student5=StudentV3("'ece")
    val student6=StudentV3(gpa=3.0, name="Melisa")
    val student7 = StudentV4("İlayda",4.0)
    val student8= StudentV4("ziya",3.6,"computer science")
    student8.student_id="2023203043"
    println(student8.program)
    println(StudentV5.universtiy)
    StudentV5.giveInfo()
    println(student2)

    var student9= StudentV6("Nuri","MIS")
    println(student9)
}