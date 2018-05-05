# Hello Kotlin

Discovering Kotlin coming from Scala.

What I have found that is intersting so far:
- main method (entry point to the program) doesn't need to be in an object.
- String interpolation, it is similar to Scala except that you don't need to use 's' character before the opening qoute. In Scala `println(s"hello $name")` in Kotlin  `println("hello $name")`.


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

## Functions
- we define a function using `fun` instead of `def`.
- `return` can only be omitted for single expression functions, but not for block functions.
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