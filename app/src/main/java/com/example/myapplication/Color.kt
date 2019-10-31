package com.example.myapplication

import com.example.myapplication.Color.*

enum class Color(
    val r: Int = 0,
    val g: Int = 0,
    val b: Int = 0
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(r = 255, g = 255),
    BLUE(b = 255),
    GREEN(g = 255),
    INDIGO(r = 75, b = 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color) {
    when (color) {
        RED -> "Richard"
        ORANGE -> "Of"
        YELLOW -> "York"
        GREEN -> "Gave"
        BLUE -> "Battle"
        INDIGO -> "In"
        VIOLET -> "Vain"
    }
}

fun getWarmth(color: Color) {
    when (color) {
        RED, ORANGE, YELLOW -> "warm"
        GREEN -> "netural"
        BLUE, INDIGO, VIOLET -> "cold"
    }
}