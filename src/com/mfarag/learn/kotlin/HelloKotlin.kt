package com.mfarag.learn.kotlin

fun main(args: Array<String>) {
    val person = Person("Kotlin", 7)
    println("Hello ${person.name}!")
}

class Person(val name: String, ageInYears: Int)