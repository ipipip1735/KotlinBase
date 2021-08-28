package syntax

/**
 * Created by Administrator on 2021/6/13.
 */
fun main() {
    //方式一
//    Sequence {
//        listOf<Int>(1,2,4).iterator()
//    }.forEach { println("it is $it") }


    //方式二
    sequence{
        println("this = ${this}")
        yield(2)
        yieldAll(listOf(1,3))
        yield(4)
        yieldAll(listOf(5,7))
    }.take(3)
        .toList()
        .forEach { println("it is $it") }



}