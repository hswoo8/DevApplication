package com.example.myapplication.kotlin

import android.util.Log

data class Person(val name: String, val age: Int? = null, var married:Boolean = false)

fun main(args: Array<String>) {
    val persons = listOf(Person("영희"), Person("철수", 29, false))

    val oldestPerson = persons.maxBy { it.age ?: 0 }


    if (oldestPerson in persons){
        println("이야이야오")
    }


    val a = "ass"
    var b = "ass"
    val c = "sss"
    b = c
//    Log.d("seoungwoo -- ", a)
    println(a)

}

