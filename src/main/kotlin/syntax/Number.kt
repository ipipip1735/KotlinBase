package syntax

/**
 * Created by Administrator on 2021/6/15.
 */
fun main() {
    checkNull()//空值与非空
//    bitwise()//位运算
}

private fun checkNull() {
    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 10000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    println(boxedA === anotherBoxedA) // true
    println("boxedA is " + boxedA?.javaClass)
    println("anotherBoxedA is " + anotherBoxedA?.javaClass)
    println(boxedB === anotherBoxedB) // false
    println("boxedB is " + boxedB?.javaClass)
    println("anotherBoxedB is " + anotherBoxedB?.javaClass)
}


fun bitwise() {
//    var x = (1 shl 2)
//    println("x = ${x}")

//    x = (x shr 1)
//    println("x = ${x}")


    var x = (-1 shl 1)
    println("x = ${x}")
    x = (-1 shl 2)
    println("x = ${x}")
}