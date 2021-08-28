package syntax

/**
 * Created by Administrator on 2021/6/13.
 */
class MapTrial {
}

fun main() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)

    val doubled = numbers.map { x -> x * 2 }
    println("doubled = ${doubled}")

    val tripled = numbers.map { it * 3 }
    println("tripled = ${tripled}")
}