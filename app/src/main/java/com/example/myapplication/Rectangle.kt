package com.example.myapplication

import java.util.*

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = width == height
}

fun main() {
    var i = 0
    for (i in 0..100){

    }
    val rectangle = createRandomRectangle()
    println(rectangle.isSquare)
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}