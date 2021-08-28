package syntax

/**
 * Created by Administrator on 2021/6/13.
 */
fun main() {

    //分解对象
    val (n, i) = JD("jack", 12)
    println("n = ${n}, i = ${i}")

    //Lambda表达式接收分解
    val map = mapOf<String, OD>("one" to OD("bob", 12), "two" to OD("jack", 22))
    map.forEach { s, (id, name) ->
        println("key = ${s}, value = [id = ${id}, name = ${name}]")
    }
}


data class JD(var name: String, var id: Int)

class OD(var name: String, var id: Int) {
    operator fun component1(): Int = id
    operator fun component2() = name
}
