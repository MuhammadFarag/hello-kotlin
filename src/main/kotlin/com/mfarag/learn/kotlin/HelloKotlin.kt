package com.mfarag.learn.kotlin

import java.time.LocalDate

fun main(args: Array<String>) {
    val person = Person("Kotlin", 2011)
    println("Hello ${person.name}, you are ${person.age} years old now!")
}

class Person(val name: String, private val yearOfBirth: Int) {
    val age: Int
        get() {
            return LocalDate.now().year - yearOfBirth
        }

    fun bornBefore(year: Int): Boolean = when (setOf(year, yearOfBirth)) {
        setOf(year, yearOfBirth) -> yearOfBirth <= year
        else -> false
    }

    fun bornInOrAfter(year: Int): Boolean = when {
        yearOfBirth >= year -> true
        else -> false
    }
}