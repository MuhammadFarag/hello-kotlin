package com.mfarag.learn.kotlin

fun main(args: Array<String>) {
    val nullableVariable: String? = null

    val stillNullable1: String? = if (nullableVariable != null) nullableVariable.toUpperCase() else null
    val stillNullable2: Int? = nullableVariable?.toUpperCase()?.dropLast(1)?.length


}