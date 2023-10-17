package com.yeditepe.weekthreesectionone.classesandobjects

abstract class Shape {

    abstract val area: Double
    abstract val circumfrance: Double

    abstract fun summary():String

    override fun toString(): String {
        return "Area: $area Circumfrance: $circumfrance"
    }
}

class Circle(val radius: Double): Shape(),Calculatable{
    override val area: Double
        get() = Math.PI*radius*radius
    override val circumfrance: Double
        get() = 2*Math.PI*radius

    override fun summary(): String = "Out circle has radius $radius and area $area"
    override fun calculateMeasure(): Double {
        return area
    }
}

interface Calculatable{

    abstract fun calculateMeasure(): Double
}

