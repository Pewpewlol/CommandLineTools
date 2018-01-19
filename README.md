# CommandLineTools
Welcome to CommandLineTools!

CommandLine Tools for Java and Kotlin

Creating a Menu for easy User Interactions and for different commandline output.

## Menu - Class


The menu - class is the entry point of different outputs.

```kotlin
var menu : Menu = Menu()
```

## Numbered - Function


The numbered creates a numbered output.

```kotlin
menu        .numbered()
            .repeatIf { it > 4 }
            .create("First", "Second")
            {
                menu, response ->
                when(response)
                {
                    is Int -> println("$response is integer")

                }
            }

            //[0] First
            //[1] Second
```