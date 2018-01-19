package SubMenus

import java.util.*

class NumberedLines : Menu()
{
    private var loopBreak: ((Int) -> Boolean) = {
        _ ->
        false
    }

    private var response : Int = -1

    fun  responsing(vararg menuOption: String, insideFunction: (Menu, Int) -> Unit, mylambda : () -> Unit): Unit {


        var number : Int = 0


        if (this.clearConsole)
        {
            print("\u001b[H\u001b[2J")
        }
        try{
            do {
                menuOption.forEach {
                    println("[$number] $it")
                    number++
                }
                number = 0

                mylambda()
                insideFunction(this,this.response)

            } while (this.loopBreak(this.response))
        }
        catch ( e : NoSuchElementException)
        {
            println(cancelationText)
        }

    }
    var exit : Boolean = false

    /*
    * Need a Default Exit for Strg+C : String
    * + ClearConsole : Boolean default True
    * + Loopbreak Added
    *
    * */




    fun repeatIf(predicate : (Int) -> Boolean): NumberedLines {
        this.loopBreak = predicate
        return this
    }


    fun create(vararg menuOption: String, insideFunction: (Menu, Int) -> Unit) {

        return responsing(*menuOption,insideFunction = insideFunction)
        {
            var scanner : Scanner = Scanner(System.`in`)
            response = scanner.nextInt()

        }

    }
}

