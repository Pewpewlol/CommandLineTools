# CommandLineTools
CommandLine Tools for Java and Kotlin

Creating a Menu for User Interactions

```kotlin
menu.numbered()
            .repeatIf { it > 4 }
            .create("Fisch", "Affe")
            {
                menu, response ->
                when(response)
                {
                    is Int -> println("$response ist ein Integer")

                }
            }
```