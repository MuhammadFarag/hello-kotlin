package com.mfarag.learn.kotlin

fun String.numberOfAs(): Int = this.count { it == 'A' || it == 'a' }

fun main(args: Array<String>) {
    val name = "Muhammad"
    println("$name has ${name.numberOfAs()} 'a' letters. ")
}