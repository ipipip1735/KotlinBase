import java.io.IOError

/**
 * Created by Administrator on 2021/7/28.
 */
class Pet {
    val name: String
        @JvmName("petName")
        get() = "9527"

    @JvmOverloads
    fun show(name: String = "bob") {
    }

    fun fn():Nothing{
        throw IOError(Throwable())
    }
}