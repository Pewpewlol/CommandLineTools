package SubMenus




open class Menu(
        var cancelationText : String = "Canceled"

)
{
    var clearConsole : Boolean = false
    private var NumberedLines: NumberedLines? = null
    get() {
        if (field == null)
            field = NumberedLines()
        return field
    }
    private var CommandLine: CommandLine? = null
    get() {
        if (field == null)
            field = CommandLine()
        return field
    }

    fun numbered(): NumberedLines {
        return NumberedLines as NumberedLines
    }

    fun commandLine(): CommandLine {
        return CommandLine as CommandLine
    }

    fun clear(cleanAfterwards : Boolean) : Menu
    {
        clearConsole = cleanAfterwards
        return this
    }
    protected fun clearConsole() {
        try {
            val os = System.getProperty("os.name")

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls")
            } else {
                Runtime.getRuntime().exec("clear")
            }
        } catch (e: Exception) {
            //  Handle any exceptions.
        }

    }



}

fun main(args: Array<String>) {
    var menu : Menu = Menu()

     menu.numbered()
            .repeatIf { it > 4 }
            .create("First", "Second")
            {
                menu, response ->
                when(response)
                {
                    is Int -> println("$response ist ein Integer")

                }
            }

//    menu
//            .commandLine()
//            .addExit("Baustelle")
//            .create("Fisch","Affe")
//            {
//                menu, response ->
//                when(response)
//                {
//
//                    "Fisch" -> println("It was true")
//                    "Affe" -> println("Ape")
//                }
//            }
//    var comm : Command = Command("Fisch", "fishy")
//    comm.implement {
//        println(comm.name)
//    }
//
//    menu    .clear(true)
//            .commandLine()
//            .setCommandNotFound("Fischig")
//            .addCommand(comm)
//            .create()

}






