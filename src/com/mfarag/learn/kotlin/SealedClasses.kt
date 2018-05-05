package com.mfarag.learn.kotlin

fun main(args: Array<String>) {

    fun Colour.french(): String = when (this) {
        is Colour.Red -> "Rouge"
        is Colour.Green -> "Vert"
        is Colour.Orange -> "Orange"
    }

    val colour: Colour = Colour.Red()

    println("English: ${colour.english} - French: ${colour.french()}")

}


sealed class Colour(val english: String) {
    class Red : Colour("Red")
    class Green : Colour("Green")
    class Orange : Colour("Orange")
}