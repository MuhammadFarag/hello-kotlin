package com.mfarag.learn.kotlin

fun main(args: Array<String>) {

    println(Items.Builder.fromString("1,2,3").items.first())
    println(Items.fromString("1,2,3").items.first())
    println(Items.AnotherBuilder.fromAnotherString("1,2,3").items.first())
}

data class Items(val items: List<Int>) {

    val emptyItems = empty()
    val emptyItems2 = Builder.empty()

    val anotherEmptyItems = AnotherBuilder.anotherEmpty()

    companion object Builder {
        fun fromString(s: String): Items = Items(s.split(",").map { it.toInt() })
        fun empty(): Items = Items(listOf())
    }

    object AnotherBuilder {
        fun fromAnotherString(s: String): Items = Items(s.split(",").map { it.toInt() })
        fun anotherEmpty(): Items = Items(listOf())
    }
}