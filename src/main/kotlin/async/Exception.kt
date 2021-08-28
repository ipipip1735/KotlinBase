package async

import kotlinx.coroutines.*
import kotlinx.coroutines.NonCancellable.children
import kotlinx.coroutines.channels.actor
import kotlin.concurrent.thread
import kotlin.math.E
import kotlin.system.measureTimeMillis

/**
 * Created by Administrator on 2021/8/14.
 */
/**
 * 处理根协程取消异常
 */
//fun main() {
//    var coroutine: CoroutineScope? = null
//    try {
//        runBlocking {
//            coroutine = this
//            cancel()
//        }
//    } catch (e: CancellationException) {
//        println("e = ${e}")
//    }
//
//    println("coroutine = ${coroutine}")
//}

/**
 * 处理launch()异常
 */
//fun main() = runBlocking {
//    println("start")
//    try {
//        val job = launch {
//            throw Exception()
//        }
//        job.join()
//
//    } catch (e: Exception) {
//        println("e = ${e}")
//    }
//    println("end")
//}


/**
 * 处理async()异常
 */
//fun main() = runBlocking {
//    println("start")
//    val deferred = async {
//        throw Exception()
//    }
//    try {
//        deferred.await()
//    } catch (e: Exception) {
//        println("e = ${e}")
//    }
//    println("end")
//}


/**
 * 处理async()异常
 */
//fun main() = runBlocking {
//    println("start")
//    val deferred = async {
//        throw Exception()
//    }
//    try {
//        deferred.await()
//    } catch (e: Exception) {
//        println("e = ${e}")
//    }
//    println("end")
//}


/**
 * 处理async()异常
 */
//fun main() = runBlocking {
////    println("start")
////    val handler = CoroutineExceptionHandler { _, exception ->
////        println("CoroutineExceptionHandler got $exception")
////    }
////    val job = launch(handler) {
////        throw Exception()
////    }
////    job.join()
//
////    val deferred = async(handler) {
////        throw Exception()(
////    }
////    deferred.await()
////    try {
////    } catch (e: Exception) {
////        println("e = ${e}")
////    }
////    println("end")
//
//
//    val handler = CoroutineExceptionHandler { _, exception ->
//        println("CoroutineExceptionHandler got $exception")
//    }
//    val job = GlobalScope.launch(handler) { // root coroutine, running in GlobalScope
//        throw AssertionError()
//    }
//    val deferred = GlobalScope.async(handler) { // also root, but async instead of launch
//        throw ArithmeticException() // Nothing will be printed, relying on user to call deferred.await()
//    }
//    joinAll(job, deferred)
//
//
//}

/**
 * 使用处理器
 */
//fun main() {
//    val handler = CoroutineExceptionHandler { coroutineContext, exception ->
//        println("exception = [${exception}], coroutineContext = [${coroutineContext}]")
//        exception.suppressed.forEach {
//            println("it = ${it}")
//        }
//    }
//    GlobalScope.launch(handler) {
//        launch {
//            println("[job1]start|$this|${Thread.currentThread()}")
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 3000L) break
//            }
//            println("[job1]end|$this|${Thread.currentThread()}")
//            throw Exception("job1")
//        }
//        launch {
//            println("[job2]start|$this|${Thread.currentThread()}")
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 2000L) break
//            }
//            println("[job2]end|$this|${Thread.currentThread()}")
//            throw Exception("job2")
//        }
//    }
//    Thread.sleep(5000L)
//}


/**
 * 使用监控作用域
 */
fun main() {
    //监控作用域是同步的，其子任务是异步的
//    runBlocking {
//        println("runBlocking|start")
//        supervisorScope{
//            println("[supervisorScope]start|$this|${Thread.currentThread()}")
//            launch {
//                println("[supervisorScope|job]start|$this|${Thread.currentThread()}")
//                val start = System.currentTimeMillis()
//                while (true) {
//                    if (System.currentTimeMillis() - start > 2000L) break
//                }
//                println("[supervisorScope|job]end|$this|${Thread.currentThread()}")
//            }
//            println("[supervisorScope]start|$this|${Thread.currentThread()}")
//        }
//
//        launch {
//            println("[job1]start|$this|${Thread.currentThread()}")
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 2000L) break
//            }
//            println("[job1]end|$this|${Thread.currentThread()}")
//        }
//
//        println("runBlocking|end")
//    }

    //使用错误处理器
    val handler = CoroutineExceptionHandler { coroutineContext, exception ->
        println("exception = [${exception}], coroutineContext = [${coroutineContext}]")
        exception.suppressed.forEach {
            println("it = ${it}")
        }
    }

    val job = GlobalScope.launch(handler) {
        supervisorScope {
            println("supervisorScope|this = ${this}")
            //throw Exception()
            launch {
                println("supervisorScope|launch|this = ${this}")
                throw Exception()
            }
        }
    }
    println("job = ${job}")
    Thread.sleep(1000L)
    println("job = ${job}")
}