package SubMenus






open class Menu(
        var cancelationText : String = "Canceled"

)
{

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


}

fun main(args: Array<String>) {
    var menu : Menu = Menu()

//     menu.numbered()
//            .repeatIf { it > 4 }
//            .create("Fisch", "Affe")
//            {
//                menu, response ->
//                when(response)
//                {
//                    is Int -> println("$response ist ein Integer")
//
//                }
//            }

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
    var comm : Command = Command("Fisch", "fishy")
    comm.implement {
        println(comm.name)
    }

    menu    .commandLine()
            .setcommandNotFound("Fischig")
            .addCommand(comm)
            .create()

}






