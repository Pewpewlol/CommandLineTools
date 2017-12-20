package SubMenus


open class Menu(
        var cancelationText : String = "Canceled"

)
{
    private var IntResponse : IntResponse? = null
    get() {
        if (field == null)
            field = IntResponse()
        return field
    }
    private var Command : Command? = null
    get() {
        if (field == null)
            field = Command()
        return field
    }

    fun numbered(): IntResponse {
        return IntResponse as IntResponse
    }

    fun commandLine(): Command {
        return this.Command as Command


    }

}

fun main(args: Array<String>) {
    var menu : Menu = Menu()

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


}






