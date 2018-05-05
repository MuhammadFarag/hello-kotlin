package com.mfarag.learn.kotlin


fun main(args: Array<String>) {
    val girl = Girl("Sophie")
    val boy = Boy("Jack")
    println(babyGreetings(girl))
    println(babyGreetings(boy))

}

fun babyGreetings(baby: Baby): String =
        when (baby) {
            is Girl -> "Hi ${baby.girlName}, little baby girl"
            is Boy -> "Hi ${baby.boyName}, little baby boy"
            else -> "Hi little baby"
        }


enum class Colour {
    PINK, BABY_BLUE
}

interface Baby

class Boy(val boyName: String) : Baby
class Girl(val girlName: String) : Baby
