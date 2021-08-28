package syntax

/**
 * Created by Administrator on 2021/6/16.
 */
fun main() {
    //非安全转换
//    val y: String? = null
//    val x: String? = y as String //as是不安全的转换
//    println(x)

    //安全转换
    val y: String? = null
    val x: String? = y as? String
    println("x = ${x}")

//    println("i = ${i}")
//    println("j = ${j}")
}

public var i = 3
private var j = 3
