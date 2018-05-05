package com.mfarag.learn.kotlin

fun main(args: Array<String>) {
    val nameAndAge: Map<String, Int> = mapOf("Jack" to 25, "Jane" to 21)
    for ((name, age) in nameAndAge) {
        println("My name is $name and I am $age years old")
    }

    val names = listOf("Muhammad", "Justin")
    for ((index, name) in names.withIndex()) {
        println("$index: $name")
    }

    println("The longest name is: ${names.maxBy(String::length)}")
    val lambda: (String) -> Int = { it.length }
    println("The shortest name is: ${names.minBy(lambda)}")

    if ("Kate" !in names) println("Kate is not here")

}