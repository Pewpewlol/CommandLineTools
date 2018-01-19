package SubMenus

import javafx.collections.transformation.SortedList
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

class CommandLine(
        cancellationText: String = "Canceled",
        var printString: String = ">> "
) : Menu(cancellationText)
{
    private var commandList : TreeSet<Command> = TreeSet()
    private val exitCommand : ArrayList<String> = ArrayList()
    private var longestName : Int = 0
    private var executed : Boolean = true
    var commandNotFound : String = "Command not found"

    init {
        exitCommand.add(":q")
        exitCommand.add("exit")
    }


    var response : String by Delegates.notNull()
    fun addExit (vararg exitCommands : String) : CommandLine
    {
        exitCommands.forEach {
            this.exitCommand.add(it)
        }
        return this
    }

    fun setCommandNotFound(text : String): CommandLine {
        commandNotFound = text
        return this
    }


    fun addCommand (Command : Command) : CommandLine
    {
        commandList.add(Command)
        return this
    }

    private fun getLongestName() {
        commandList.forEach{
            if (it.name.length > longestName)
                longestName = it.name.length

        }
        exitCommand.forEach {
            if (it.length > longestName)
                longestName = it.length
        }
    }

    fun create(): Unit {


        if (clearConsole)
        {
            clearConsole()
        }


        while (true)
        {
            executed = false // set excution of Command not done


            print(printString) // print the Names of the Commands

            val scan : Scanner = Scanner(System.`in`)
            response = scan.next()

            // Exits the Programm
            exitCommand.forEach{
                if (response == it)
                    return
            }

            if (response == "help")
            {
                executed = true
                getLongestName()

                commandList.forEach {
                    print("${it.name}")
                    for (zähler in 0..(longestName-it.name.length))
                        print(" ")
                    println(": ${it.description}")
                }
                exitCommand.forEach {
                    print("$it")
                    for (zähler in 0..longestName-it.length)
                        print(" ")
                    println(": exits the Programm")
                }
            }
            else
            {
                commandList.forEach{
                    if (response == it.name)
                    {
                        it.execute()
                        executed = true
                        return@forEach
                    }
                }

            }

            if (!executed)
            {
                println(commandNotFound)
            }



        }




    }




}