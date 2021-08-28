package syntax

import kotlin.math.nextDown
import kotlin.math.nextUp

/**
 * Created by Administrator on 2021/6/16.
 */
fun main() {

    usingWhen()
}

fun usingReturnWithValue() {

    listOf(listOf(1, 2, 3), listOf(4, 5, 6))
        .forEach one@{
            println("one|it = ${it}")
            it.forEach {
                println("two|it = ${it}")
                return@one
            }
        }
}

fun usingLoop() {

    sss@ for (i in 1..100) {
        println("i = ${i}")
        for (j in 1..100) {
            if (j > 5) break@sss
            println("j = ${j}")
        }
    }


}

fun usingReturn() {

    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return
        print(it)
    }
    print("end!")

}

private fun usingWhen() {

    //方式一
//    val x: Int = 2;
//    val y: Int = 32;
//
//    when {
//        x > 1 -> println("x = ${x}")
//        y > 1 -> println("y = ${y}")
//    }


    //方式二
//    val n = 0.5
//    println("n = ${n}")
//    val k = when (n) {//声明变量n
//        0.1 -> 1.3
//        0.3, 0.35 -> 9
//        in 0.4..0.5 -> 1
//        else -> 10
//    }
//    println(k)//不可访问n


    //方式三：使用Lambda表达式
    val k = when (val n = 3.5) {//声明变量n
        0.1 -> {
            println("n = ${n}")
            1.3
        }
        else -> {
            println("error!!!!!")
            3.6
        }
    }
//    println(k)//不可访问n
//    println(n)//不可访问n

    //方式四：when声明（可以省略else语句）
    when {
        true -> println("ok")
        false -> println("no")
    }

    //方式五：when表达式（必须有else语句）
    val b = when {
        true -> println("ok")
        false -> println("no")
        else -> println("error")
    }

}