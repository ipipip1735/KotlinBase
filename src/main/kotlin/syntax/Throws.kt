package syntax

/**
 * Created by Administrator on 2021/9/1.
 */
class Throws {
    @kotlin.jvm.Throws(Exception::class)
    fun show() {
        throw Exception("xxx")
    }

    fun view() {
        throw Error("xxx")
    }

}


fun main() {
    val t = Throws()

    t.show()
}