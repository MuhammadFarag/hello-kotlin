package com.mfarag.learn.kotlin


fun main(args: Array<String>) {
    val girl = Girl("Sophie")
    val boy = Boy("Jack", 7)
    println(babyGreetings(girl))
    println(babyGreetings(boy))

}

fun babyGreetings(child: Child): String =
        when {
            child is Girl -> "Hi ${child.girlName}, little girl"
            child is Boy && child.age <= 1 -> "Hi ${child.boyName}, little baby boy"
            child is Boy -> "Hi ${child.boyName}"
            else -> "Hi"
        }

interface Child

class Boy(val boyName: String, val age: Int) : Child
class Girl(val girlName: String) : Child
