package com.mfarag.learn.kotlin

fun main(args: Array<String>) {
    val nullableVariable: String? = null

    nullableVariable?.let { println(it) }

    val stillNullable1: String? = if (nullableVariable != null) nullableVariable.toUpperCase() else null
    val stillNullable2: Int? = nullableVariable?.toUpperCase()?.dropLast(1)?.length

    val notNullableAnyMore1: String = nullableVariable ?: "I can breath!"
    // val notNullableAnyMore2: String = nullableVariable!!.toUpperCase() // Throws an NP

    val notTrusted: String? = JavaLibrary.nullableValue1
    JavaLibrary.nullableValue1?.length
    val trusted: String = JavaLibrary.nullableValue2
    JavaLibrary.nullableValue2.length


}