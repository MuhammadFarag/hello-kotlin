package com.mfarag.learn.kotlin

fun main(args: Array<String>) {
    val x: Int = try {
        throw Exception()
    } catch (e: Exception) {
        0
    }

    println(x)

}