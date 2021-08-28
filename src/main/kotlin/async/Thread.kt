package async

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis

/**
 * Created by Administrator on 2021/8/7.
 */
fun main() {
    //使用Thread对象
//    val theThread = TheThread()
//    theThread.start()

    //使用匿名对象
//    object : Thread() {
//        override fun run() {
//            println("${Thread.currentThread()}")
//        }
//    }.start()

    //使用Lambd表达式
//    Thread{
//        println("${Thread.currentThread()}")
//    }.start()

    //使用thread()方法
//    thread(true) {
//        println("${Thread.currentThread()}")
//    }

}

class TheThread : Thread() {
    override fun run() {
        println("${Thread.currentThread()}")
    }
}