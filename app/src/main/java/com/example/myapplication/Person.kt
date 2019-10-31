package com.example.myapplication


class Person(
    val name: String,
    var isMarried: Boolean,
    val age: Int
) {

//    constructor(name: String, isMarried: Boolean, age:Int){
//        this.age = age
//        this.name = name
//        this.isMarried = isMarried
//    }


}
//data class Person(
//    val name: String,
//    val age: Int? = null
//)
//
//private fun findPerson(op: (person: Person) -> Unit) {
//    //??
//}
//
//fun main(args: Array<String>) {
//    findPerson {
//        it.name == "Alice"
//    }
//    val persons = listOf(Person("영희"), Person("철수", 29))
//    val oldest = persons.maxBy { it.age ?: 0 }
//    println("나이가 가장 많은 사람 : $oldest")
//
//    println("hello, world")
//    println(max(1, 2))
//
//    val question = "삶, 우주, 그리고 모든 것에 대한 궁극적인 질문"
//    val answer = 42
//    val answer1: Int = 42
//
//    val a: Int
//    a = 1
//
//    val message: String
//    message = if (a > 0) "success" else "fail"
//    val language = arrayListOf("Java")
//    language.add("kotlin")
//
//    val name = if (args.size > 0) args[0] else "Kotlin"
//    println("Hello, $name!")
//
//}
//
//
//fun max(a: Int, b: Int): Int {
//    return if (a > b) a else b
//}
//
//fun oMax(a: Int, b: Int): Int = if (a > b) a else b
//fun upgradeMax(a: Int, b: Int) = if (a > b) a else b
//
//
//fun f(function: (name: String) -> Boolean) {
//
//
//}
//
////fun findPerson(function: (name: String) -> Boolean): Boolean {
////    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
////}
//

