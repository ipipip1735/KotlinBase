package syntax

/**
 * Created by Administrator on 2021/6/13.
 */
enum class EnumA{
    AA, BB
}

fun main() {

    val enumA = EnumA.AA
    val k = when (enumA) {
        EnumA.AA -> TODO()
        EnumA.BB -> TODO()
    }
    println("k = ${k}")
}


