package syntax

/**
 * Created by Administrator on 2021/8/11.
 */
fun main() {
    val i = 9
    when (i) {
        1,3 -> println("odd")
        is Int -> println("Int")
        else -> println("xxx")
    }
}