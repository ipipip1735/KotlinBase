package syntax

import java.util.*
import kotlin.reflect.KClass

/**
 * Created by Administrator on 2021/6/16.
 */
fun main() {

    //使用匿名类实现函数式接口
//    val o: OneFI = object : OneFI {
//        override fun one(i: Int): Int {
//            return 1
//        }
//    }

    //表达式函数
//    val k = expression(6)
//    if (k is Float) println("float|k is $k")

    //使用Lambda表达式实现函数式接口
//    lambda()


    //递归函数
//    tf(5)


    //内联函数
    println("start")
    inlinefun()
    println("end")


    //实例化参数
//    sevenIF<String>(String::class)
//    eightIF<String>()
}

fun inlinefun() {

    //使用容器（容器的运算函数几乎都是内联函数）
    //    listOf<Int>(1, 2, 4, 6).forEach{
//        println("forEach|start")
//        return@fe
//        println("it is $it")
//        println("forEach|end")
//    }

//    listOf<Int>(1, 2, 4, 6).forEach fe@{
//        println("forEach|start")
//        return@fe
//        println("it is $it")
//        println("forEach|end")
//
//    }


    //例二
    oneIF(1) {
        return@oneIF
        println("xxxxxx")
    }


    //例三
//    twoIF(2) {
//        println("it = ${it}")
//    }

    //例四
//    threeIF(2, { println("it = ${it}") }) {
//        println("it = ${it}")
//    }

    //例五
//    fourIF(1){
//        println("it = ${it}")
//        return
//    }

    //例六
//    sixIF(1){
//        println("it = ${it}")
//    }
}


/**
 * 表达式函数
 */
fun expression(k: Int) = k + 3.5f//强制类型转换


/**
 * Lambda表达式
 */
fun lambda() {

//    val k: OneFI = OneFI { i ->
//        if (i > 0) return@OneFI 1
//        println("i = ${i}")
//        i
//    }
//    println("k.one(9) is " + k.one(9))

//    val a: TwoFI = TwoFI {
//        println("xxx")
//        2
//    }
//    println("a.two() is ${a.two()}")

//    val three: ThreeFI = ThreeFI { _, j ->
////        println("_ = ${_}")//变量名为_时，不允许引用
//        println("j = ${j}")
//    }


//    val sum: AF.(Int) -> Int = {
//        println(int)
//        1
//    }
//    println("sum(AF(), 22) is " + sum(AF(), 22))


    //使用return标记
//    println("start")
//    listOf<Int>(1,2,3).forEach list@{
//        if(it == 2)return@list
//        println("$it")
//    }

//    listOf<Int>(1,2,3).forEach{
//        if(it == 2)return
//        println("$it")
//    }
//    println("end")
}

//函数式接口
fun interface OneFI {
    fun one(i: Int): Int
}

fun interface TwoFI {
    fun two(): Int
}

fun interface ThreeFI {
    fun three(i: Int, j: Int)
}


class AF {
    val int: Int = 3
}

/**
 * 尾递归函数
 */
fun tf(i: Int): Int {
    var n = i - 1
    println("s|n = ${n}")
    if (n < 0) return 0
    tf(n)
    println("e|n = ${n}")
    return n
}


/**
 * 内联函数
 */
inline fun oneIF(int: Int, fn: (Int) -> Unit) {
    println("int = ${int}")
    println("oneIF|start")
    fn(int)
    println("oneIF|end")
}

fun twoIF(int: Int, fn: (Int) -> Unit) {
    println("int = ${int}")
    fn(int)
}

inline fun threeIF(int: Int, noinline fn1: (Int) -> Unit, noinline fn2: (Int) -> Unit) {
    println("int = ${int}")
    fn1(int)
    fn2(int)
}

inline fun fourIF(int: Int, fn: (Int) -> Unit) {
    println("start")
    fn(int)
    println("end")
}

inline fun fiveIF(int: Int, noinline fn: (Int) -> Unit): (Int) -> Unit {
    println("start")
    fn(int)
    println("end")
    return fn
}

inline fun sixIF(int: Int, fn: (Int) -> Unit) {
    val f = object : Runnable {
        override fun run() = fn()
    }
}

fun <T : Any> sevenIF(kClass: KClass<T>) {
    val ss: List<String> = listOf("one")
    println("ss is T = ${kClass.isInstance(ss[0])}")
}

inline fun <reified T> eightIF() {
    val ss: List<String> = listOf("one")
    println("ss is T = ${ss[0] is T}")
}
