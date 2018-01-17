package SubMenus


data class Command(
        var name : String,
        var description : String
) : Comparable<Command>
{
    override fun compareTo(other: Command): Int {
        return other.hashCode()
    }

    lateinit var execute : () -> Unit

    fun implement(init: () -> Unit) {

        execute = init

    }

}