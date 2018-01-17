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
    private var longestName : Int = 0;
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
    fun create(vararg menuCommands : String, insideFunction: (Menu,String) -> Unit): Unit {

        while (true)
        {
            print(printString)
            val scan : Scanner = Scanner(System.`in`)

            response = scan.next()
            exitCommand.forEach{
                if (response == it)
                    return
            }
            if (response == "help")
            {
                menuCommands.forEach {
                    println(it)
                }
            }
            else
            {
                insideFunction(this,response)
            }


        }


    }
    fun create(): Unit {

    while (true)
    {
        print(printString)
        val scan : Scanner = Scanner(System.`in`)
        getLongestName()
        response = scan.next()
        exitCommand.forEach{
            if (response == it)
                return
        }
        if (response == "help")
        {

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
                    return@forEach
                }
            }
        }


    }


}

}