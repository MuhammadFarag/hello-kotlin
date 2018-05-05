# Hello Kotlin

Discovering Kotlin coming from Scala.

What I have found that is intersting so far:
- main method (entry point to the program) doesn't need to be in an object.
- we define a function using `fun` instead of `def`.
- `return` can only be omitted for single expression functions, but not for block functions.
- String interpolation, it is similar to Scala except that you don't need to use 's' character before the opening qoute. In Scala `println(s"hello $name")` in Kotlin  `println("hello $name")`.
- If you have a Java class that has getters and setters for some property, i.e. `getSomeProperty` and `setSomeProperty`, Kotlin let's you use it as a property directly, instead of using the methods, i.e. `val x = instance.someProperty` and `instance.someProperty = someValue`.
