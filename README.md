# Hello Kotlin

Discovering Kotlin coming from Scala. I am going throght [Kotlin in Action](https://www.manning.com/books/kotlin-in-action), trying few simple examples and writing my notes in the process.

What I have found that is intersting so far:
- main method (entry point to the program) doesn't need to be in an object.
- String interpolation, it is similar to Scala except that you don't need to use 's' character before the opening qoute. In Scala `println(s"hello $name")` in Kotlin  `println("hello $name")`.
- Files are indented at four spaces compared to Scala's two spaces.

## Inheritance

- Scala `extends` turns to be a `:`. So we have `class ClassName : SomeInterface`

## Pattern matching
### Simple pattern matching
```kotlin
when (baby) {
    is Girl -> "Hi ${baby.girlName}, little baby girl"
    is Boy -> "Hi ${baby.boyName}, little baby boy"
    else -> "Hi little baby"
}
```
### Tad more complex pattern matching
```Kotlin
when {
    child is Girl -> "Hi ${child.girlName}, little girl"
    child is Boy && child.age <= 1 -> "Hi ${child.boyName}, little baby boy"
    child is Boy -> "Hi ${child.boyName}"
    else -> "Hi"
}
```
### Sealed classes
To define a sealed class:
```kotlin
sealed class Colour(val english: String) {
    class Red : Colour("Red")
    class Green : Colour("Green")
    class Orange : Colour("Orange")
}
```
In the previous examples for pattern matching, we have noticed the `else -> ...` segment, which is required when classes are not sealed. With sealed classes. This is not the case. Let's extend the previous example
```kotlin
fun Colour.french(): String = when (this) {
    is Colour.Red -> "Rouge"
    is Colour.Green -> "Vert"
    is Colour.Orange -> "Orange"
}
```
Intellij IDEA will give you the option to fill all the options evaluating it to `TODO()`, which is similar Scala's `???`. or else, if you have implemented one of the options, and want to default on the rest.

## Functions
- we define a function using `fun` instead of `def`.
- `return` can only be omitted for single expression functions, but not for block functions. Note, that other than that case, the last expression in a block is its result.
- Functions can live at the root livel of any Kotlin file. There is no concept of package objects (as far as I have seen so far).
```
package ...

import ...

fun someFunction{
  ...
}
```

## Getters and Setters
- If you have a Java class that has getters and setters for some property, i.e. `getSomeProperty` and `setSomeProperty`, Kotlin let's you use it as a property directly, instead of using the methods, i.e. `val x = instance.someProperty` and `instance.someProperty = someValue`.

### Custom getters

I don't find the following code particulary useful, I would just use a method instead. Where I think something similar might shine is with setters, maybe.
```kotlin
val age: Int
    get() {
        return LocalDate.now().year - yearOfBirth
    }
```

I believe in Scala, you can't tie a custom getter or setter to the same val/var. you will have a different private val, which you might call `_age` and then use two methods to get and set that variable as needed, I believe something in the lines of `def age:Int` and `def age_=(age:Int)`. I might be a big fuzzy on this, didn't use it since forever.

## Iterators

Defining a range is inclusive, the following snippet counts down from 100 to 0, with 0 and 100 included.

```kotlin
for (i in 100 downTo 0 step 2){
    // Do something
}
```
The count up with no step is simpler `for (i in 0..10)`, again both 0 and 10 are included.
Interestingly you can also use `for(c in 'A'..'Z')`

### Iterating over maps

```kotlin
val nameAndAge: Map<String, Int> = mapOf("Jack" to 25, "Jane" to 21)
for ((name, age) in nameAndAge) {
    println("My name is $name and I am $age years old")
}
```

### Iterating over collections with indexes

```kotlin
val names = listOf("Muhammad", "Justin")
for ( (index, name) in names.withIndex()){
    println("$index: $name")
}
```

To check if an element exists in a collection we use the keywords `in` and `!in`

```kotlin
val names = listOf("Muhammad", "Justin")
if ("Kate" !in names) println("Kate is not here")
```

## Try-catch

Returnign default value in case of exception:
```
val x: Int = try {
    throw Exception()
} catch (e: Exception) {
    0
}
```

## Extending existing Classes
With Scala we use an implicit class with one argument constructor, which is the type we want to extend. In Kotlin, the syntax for extension functions is:
```kotlin
fun String.numberOfAs(): Int = this.count { it == 'A' || it == 'a' }
```
or you can use extention properties syntax:
```kotlin
val String.numberOfBs: Int
    get() = this.count { it == 'A' || it == 'a' }
```

### Companion object
Scala requires a companion object to have the same name as its companion class and it has to be in the same file. In Kotlin however it is required to be within the class and use the keywords `companion object`. Object name in that case is optional, which makes things a bit interesting. And finally you can have only one companion object within your class.

```kotlin
data class Items(val items: List<Int>) {

    val emptyItems = empty()
    val anotherEmptyItems = Builder.empty()

    companion object Builder {
        fun fromString(s: String): Items = Items(s.split(",").map { it.toInt() })
        fun empty(): Items = Items(listOf())
    }
}

data class Items(val items: List<Int>) {

    fun playWithEmpty() {
        test()
        Builder.test()
    }


    companion object Builder {
        fun fromString(s: String): Items = Items(s.split(",").map { it.toInt() })
        fun test() = println("builder test")
    }
}

```

If you choose to have a name for your companion object, you can access its members either directly, or by qualifying them by the name. This is not only inside the class, but wherever the class is called, for an example:

```kotlin
println(Items.fromString("1,2,3").items.first()) // valid
println(Items.Builder.fromString("1,2,3").items.first()) // valid and does the same thing
```

It seems that the primary difference between the two approaches (having or omitting the companion object name) is how you call it from Java. Without explicit naming you would use `Items.Companion.fromString(...)` with the name, you'd use `Items.Builder.fromString(...)`.

Extending a companion object:

```kotlin
fun Items.Builder.firstExtensionMethod() = println("I am an extension method")

Items.firstExtensionMethod()
Items.Builder.firstExtensionMethod()
```

## Lambdas
Lambda has to be surrounded by curly braces.
```kotlin
val names = listOf("Muhammad", "Justin")

val lambda: (String) -> Int = { it.length }
println("The shortest name is: ${names.minBy(lambda)}")

println("The shortest name is: ${names.minBy { it.length }}")

println("The longest name is: ${names.maxBy(String::length)}")
```

## Option Type (nullable)
Kotlin doesn't have option type. It has what I might consider a better alternative. if you try this in Kotlin the compiler will scream right at you, you just can't do it:
```kotlin
val x:String = null
```
But how do you manage `null` or in Scala type `Option` which can be `Some` or `None`? Here is how:
```kotlin
val x:String? = null
```
By adding `?` after your type on declaration, it let's the compiler know that you have no clue. Using the analogy to Scala. This is like declaring an `Option` which maybe hold a value (i.e. `Some`) or be `null` (i.e. `None`)