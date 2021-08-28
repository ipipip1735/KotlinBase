package async


import java.util.*
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

/**
 * Created by Administrator on 2021/8/7.
 */
fun main() {

    //单次任务
//    Timer().schedule(timerTask {
//        println("${Thread.currentThread()}")
//    }, 1000L)


    //周期任务可以使用工具函数
    val t = timer("oo", period = 1000L){
        println("${Thread.currentThread()}")
    }
    println("t = ${t}")

}