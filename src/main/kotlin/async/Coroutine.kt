package async

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.system.measureTimeMillis

/**
 * Created by Administrator on 2021/7/29.
 */
/**
 * 使用Coroutine
 */
//fun main() {
//
//    //协程默认是单线程
////    println("main|start")
////    runBlocking {
////        println("runBlocking|start")
////        val job1:Job = launch {
////            println("job1|start|${Thread.currentThread()}|${System.currentTimeMillis()}")
////            println("this is $this")
////
////            val start = System.currentTimeMillis()
////            while (true) {
////                if (System.currentTimeMillis() - start > 3000L) break
////            }
////
////            println("job1|end|${Thread.currentThread()}|${System.currentTimeMillis()}")
////        }
////        println("job1 = ${job1}")
////
////        val job2 =  launch {
////            println("job2|${Thread.currentThread()}|${System.currentTimeMillis()}")
////        }
////        println("job2 = ${job2}")
////
////        println("runBlocking|end")
////    }
////    println("main|start")
//
//
//    //协程任务是一轮一轮处理的，挂起必须等到下一轮才能重启
////    runBlocking {
////        val job1: Job = launch {
////            println("job1|start|${Thread.currentThread()}|${System.currentTimeMillis()}")
////            delay(1000L)
////            println("this is $this")
////            println("job1|end|${Thread.currentThread()}|${System.currentTimeMillis()}")
////        }
////        println("job1 = ${job1}")
////
////        val job2 = launch {
////            println("job2|start|${Thread.currentThread()}|${System.currentTimeMillis()}")
////            val start = System.currentTimeMillis()
////            while (true) {
////                if (System.currentTimeMillis() - start > 3000L) break
////            }
////            println("job2|end|${Thread.currentThread()}|${System.currentTimeMillis()}")
////        }
////        println("job2 = ${job2}")
////    }
//
//
//    //超时限制
//    runBlocking {
//        withTimeout(3000L) {
//            val start = System.currentTimeMillis()
//            println("start|$start")
//            while (System.currentTimeMillis() - start < 5000L) yield()
//            println("end|${System.currentTimeMillis()}")
//        }
//    }
//}


/**
 * 自定义Coroutine
 */
//fun main() {
//    val p = 100.0f
//    val coroutine = TheCoroutine(p, EmptyCoroutineContext, true, true)
//    coroutine.start(CoroutineStart.DEFAULT, coroutine) {
//        println("this is $this|${Thread.currentThread()}")
//        println("start")
////        coroutine.p*3
//        throw Exception()
////        cancel()
////        yield()
//        println("end")
//        0.0f
//    }
//}


@OptIn(InternalCoroutinesApi::class)
class TheCoroutine(val p: Float, parentContext: CoroutineContext, initParentJob: Boolean, active: Boolean) :
    AbstractCoroutine<Float>(parentContext, initParentJob, active) {
    override fun onCancelled(cause: Throwable, handled: Boolean) {
        println("~~TheCoroutine.onCancelled~~")
        println("cause = [${cause}], handled = [${handled}]|${Thread.currentThread()}")
    }

    override fun onCompleted(value: Float) {
        println("~~TheCoroutine.onCompleted~~")
        println("value = [${value}]|${Thread.currentThread()}")
    }
}