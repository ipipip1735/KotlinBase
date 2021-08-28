package async

import kotlinx.coroutines.*
import java.io.Closeable
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

/**
 * Created by Administrator on 2021/7/29.
 */
/**
 * 使用Coroutine
 */
//fun main() {
//
//    //方式一
////    runBlocking {
////        println("this is $this")
////        val n: Int = coroutineScope {
////            println("this is $this")
////            println("this.coroutineContext is ${this.coroutineContext}")
////            println("this@runBlocking.coroutineContext is ${this@runBlocking.coroutineContext}")
////            println("job|start|${Thread.currentThread()}|${System.currentTimeMillis()}")
////            val start = System.currentTimeMillis()
////            while (true) {
////                if (System.currentTimeMillis() - start > 3000L) break
////            }
////            println("job|end|${Thread.currentThread()}|${System.currentTimeMillis()}")
////            1
////        }
////        println("n = ${n}|${Thread.currentThread()}|${System.currentTimeMillis()}")
////    }
//
////    runBlocking {
////        println("this is $this")
////        val n: Int = coroutineScope {
////            launch {
////                println("job1|start|${Thread.currentThread()}|${System.currentTimeMillis()}")
////                val start = System.currentTimeMillis()
////                while (true) {
////                    if (System.currentTimeMillis() - start > 3000L) break
////                }
////                println("job1|end|${Thread.currentThread()}|${System.currentTimeMillis()}")
////            }
////            launch {
////                println("job2|start|${Thread.currentThread()}|${System.currentTimeMillis()}")
////            }
////            1
////        }
////        println("n = ${n}|${Thread.currentThread()}|${System.currentTimeMillis()}")
////    }
//
//
//    //方式二
////    println("start")
////    println("one|start")
////    oneC()
////    println("one|end")
////    println("two|start")
////    twoC()
////    println("two|end")
////    println("end")
//
//
//    //方式三
//    threeC()
//
//    //方式四
////    runBlocking {
//////        println("1|start")
//////        fourC()
//////        println("1|end")
//////        println("2|start")
//////        fourC()
//////        println("2|end")
//
//    //方式五
////        fiveC()
////
////    }
//}


//fun oneC() = runBlocking {
//    launch {
//        delay(1000L)
//        println("one|async")
////        delay(5000L)
////        println("two|async")
//    }
//    measureTimeMillis {}
////    delay(5000L)
//    println("one")
//}
//
//fun twoC() = runBlocking {
//    launch {
////        delay(1000L)
//        println("two|async")
//    }
//    println("two")
//}
//
//fun threeC() = runBlocking {
//    launch {
//        println("three|async")
//        sfn()
//    }
//    println("three")
//}
//
//suspend fun sfn() {
//    delay(5000L)
//    println("xxxxxxxxxxx")
//}
//
//suspend fun fourC() = coroutineScope {
//    launch {
//        delay(3000L)
//        println("four1|async")
//    }
//    launch {
//        println("four2|async")
//    }
//    println("four")
//}
//
//suspend fun fiveC() = coroutineScope {
//    val job = launch {
//        delay(3000L)
//        println("four1|async")
//    }
//
//    job.join()
//
//    launch {
//        println("four2|async")
//    }
//
//}


/**
 * 使用线程
 */
//fun main() {
//    repeat(2) { // launch a lot of coroutines
//        thread {
//            Thread.sleep(1000L)
//            print(".")
//        }
//    }


/**
 * 懒加载
 */
//fun main() = runBlocking {
//    println("start|${java.lang.Thread.currentThread()}|${java.lang.System.currentTimeMillis()}")
//
//
//    //立即启动协程
////    val job: Job = launch(start = CoroutineStart.DEFAULT) {
////        println("job|start|${Thread.currentThread()}|${System.currentTimeMillis()}")
////        println("job|end|${Thread.currentThread()}|${System.currentTimeMillis()}")
////    }
////    job.cancel()
//
//
//    //懒加载
////    val job: Job = launch(start = CoroutineStart.ATOMIC) {
////        println("job|start|${Thread.currentThread()}|${System.currentTimeMillis()}")
////        println("job|end|${Thread.currentThread()}|${System.currentTimeMillis()}")
////    }
////    job.start()
//
//
//    //自动判断
////    val job: Job = launch(start = CoroutineStart.ATOMIC) {
////        println("job|start|${Thread.currentThread()}|${System.currentTimeMillis()}")
////        println("job|end|${Thread.currentThread()}|${System.currentTimeMillis()}")
////    }
////    job.cancel()
//
//    //自动
//    val job: Job = launch(start = CoroutineStart.UNDISPATCHED) {
//        println("job|start|${Thread.currentThread()}|${System.currentTimeMillis()}")
//        val start = System.currentTimeMillis()
//        while (true) {
//            if (System.currentTimeMillis() - start > 3000L) break
//        }
//        delay(1000L)
//        println("job|end|${Thread.currentThread()}|${System.currentTimeMillis()}")
//    }
//
//    println("end|${java.lang.Thread.currentThread()}|${java.lang.System.currentTimeMillis()}")
//}


/**
 * 线程切换
 */
@OptIn(ExperimentalStdlibApi::class)
fun main() {
    println("start")
    //方式一
    runBlocking(newSingleThreadContext("ST")) {
        launch {
            delay(1000L)
            println("runBlocking|${Thread.currentThread()}|$coroutineContext")
        }
        println("coroutineContext[ExecutorCoroutineDispatcher] = ${coroutineContext[ExecutorCoroutineDispatcher]}")
        coroutineContext[ExecutorCoroutineDispatcher]?.close()
    }

    //方式二
//    newSingleThreadContext("ST").use {
//
//        runBlocking(it) {
//            println("runBlocking|start|coroutineContext = ${coroutineContext}|${Thread.currentThread()}")
//
//            launch {
//                println("job1|start|coroutineContext = ${coroutineContext}|${Thread.currentThread()}")
//                val start = System.currentTimeMillis()
//                while (true) {
//                    if (System.currentTimeMillis() - start > 3000L) break
//                }
//                println("job1|end|coroutineContext = ${coroutineContext}|${Thread.currentThread()}")
//            }
//
//            launch {
//                println("job2|start|coroutineContext = ${coroutineContext}|${Thread.currentThread()}")
//                val start = System.currentTimeMillis()
//                while (true) {
//                    if (System.currentTimeMillis() - start > 3000L) break
//                }
//                println("job2|end|coroutineContext = ${coroutineContext}|${Thread.currentThread()}")
//            }
//            println("runBlocking|end|coroutineContext = ${coroutineContext}|${Thread.currentThread()}")
//        }
//
//        it.close()
//    }

    println("end")
}

