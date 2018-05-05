package com.mfarag.learn.kotlin

fun main(args: Array<String>) {

    println(Items.Builder.fromString("1,2,3").items.first())
    println(Items.fromString("1,2,3").items.first())
    println(Items.AnotherBuilder.fromAnotherString("1,2,3").items.first())
    Items.fromString("1").playWithEmpty()

}

data class Items(val items: List<Int>) {

    fun playWithEmpty() {
        test()
        Builder.test()
        AnotherBuilder.anotherTest()
    }


    companion object Builder {
        fun fromString(s: String): Items = Items(s.split(",").map { it.toInt() })
        fun test() = println("builder test")
    }

    object AnotherBuilder {
        fun fromAnotherString(s: String): Items = Items(s.split(",").map { it.toInt() })
        fun anotherTest() = println("another builder test")
    }
}