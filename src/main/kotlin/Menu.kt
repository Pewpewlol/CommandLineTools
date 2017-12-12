import java.util.*
import kotlin.NoSuchElementException
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

class Menu(
        var cancelationText : String = "Canceled"

)
{
    private var loopBreak: (Int) -> Boolean by Delegates.notNull()
    private var clearConsole :Boolean = false
    private var response : Int = -1
    private var scan : Scanner = Scanner(System.`in`)

    var exit : Boolean = false

    /*
    * Need a Default Exit for Strg+C : String
    * + ClearConsole : Boolean default True
    * + Loopbreak Added
    *
    * */

    fun loopBack(predicate : (Int) -> Boolean): Menu {
        this.loopBreak = predicate
        return this
    }

    fun create(
            vararg menuOption : String = arrayOf("Hello","World"),
            
            cancelationText: String = "canceled",
            insideFunction : (Int) -> Unit ): Int
    {


        var number : Int = 0

        if (clearConsole)
        {
            print("\u001b[H\u001b[2J")
        }
        try {
            do {
                menuOption.forEach {
                    println("[$number] $it")
                    number++
                }
                number = 0

                this.response = scan.nextInt()
                insideFunction(this.response)

            } while (this.loopBreak(response))
        }
        catch ( e : NoSuchElementException)
        {
            println(cancelationText)
        }
        return response
    }

    
}




