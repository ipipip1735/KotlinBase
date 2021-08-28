package async

import kotlinx.coroutines.*
import kotlinx.coroutines.NonCancellable.children
import kotlinx.coroutines.channels.actor
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

/**
 * Created by Administrator on 2021/7/29.
 */
/**
 * 使用Job接口
 */
//fun main() = runBlocking {
//
//
//    /*指定Job*/
////    val job = launch(context = Job()) {
////
////    }
//
//    /*阻塞等待*/
////    val request = launch {
////        repeat(3) { i ->
////            launch  {
////                delay((i + 1) * 200L) // variable delay 200ms, 400ms, 600ms
////                println("Coroutine $i is done")
////            }
////        }
////        println("request: I'm done and I don't explicitly join my children that are still active")
////    }
//////    request.join()
////    println("Now processing of the request is complete")
//
//
//    /*处理异常*/
////    val job = launch {//launch()返回值为Job接口
////        println("async|start")
////        try {
////        } finally {
////            println("finally")
////        }
////        delay(2000L)
////        println("async|end")
////    }
//////    job.cancel()
////    println("job = ${job}")
//////    delay(1000L)
//////    job.cancel()
////    job.join()
////    println("Hello")
//
//
//    /*懒加载*/
////    val job = launch(start = CoroutineStart.LAZY) {
////        delay(2000L)
////        println("launch|go")
////    }
////
////    val k = job.start()
//
//
//    /*任务链*/
////    val job: Job = launch(CoroutineName("job")) {
////        val job1: Job = launch(CoroutineName("job1")) {
////            val job2: Job = launch(CoroutineName("job2")) {
////                println("job2|start|${Thread.currentThread()}|${System.currentTimeMillis()}")
////                val start = System.currentTimeMillis()
////                while (true) {
////                    if (System.currentTimeMillis() - start > 3000L) break
////                }
////                cancel()//取消任务
////                println("job2|end|${Thread.currentThread()}|${System.currentTimeMillis()}")
////
////            }
////            println("job2 = ${job2}")
////        }
////        println("job1 = ${job1}")
////    }
////    println("job = ${job}")
//
//
////    val job: Job = launch(CoroutineName("job")) {
////        val job1: Job = launch(CoroutineName("job")) {
////            println("job1|start|${Thread.currentThread()}|${System.currentTimeMillis()}")
////            val start = System.currentTimeMillis()
////            while (true) {
////                if (System.currentTimeMillis() - start > 3000L) break
////            }
////            println("job1|end|${Thread.currentThread()}|${System.currentTimeMillis()}")
////        }
////        job1.join()
////        println("job1 = ${job1}")
////    }
////    println("job = ${job}")
//
//
//}


/**
 * 使用Deferred接口(Job的子接口)
 */
//fun main() = runBlocking {
//
//    val deferred = async {//async()返回值为Deferred接口
//        delay(1000L)
//        println("async|one")
//        println(Thread.currentThread().name)
//        1
//    }
//
//    println("go")
//
//    val n = deferred.await()
//    println("n = ${n}")
//}


/**
 * 使用Deferred接口(Job的子接口)
 */
//fun main() = runBlocking {
//    actor {
//
//    }
//}

/**
 * 异常取消
 */
//fun main() {
//    val job = GlobalScope.launch gl@{
//        println("start|${Thread.currentThread()}|${this}")
//        val job1 = launch() {
//            yield()
//            println("[job1]start|coroutineContext = ${coroutineContext}")
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 6000L) break
//            }
//            println("[job1]end|coroutineContext = ${coroutineContext}")
//            println("[job1]runBlocking@coroutineContext is ${this@gl.coroutineContext}")
//        }
//
//        val job2 = launch() gl@{
//            println("[job2]start|coroutineContext = ${coroutineContext}")
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 3000L) break
//            }
//            println("[job2]end|coroutineContext = ${coroutineContext}")
//            println("[job2]runBlocking@coroutineContext is ${this@gl.coroutineContext}")
//            1/0
//            println("[job2]coroutineContext = ${coroutineContext}")
//            println("[job2]runBlocking@coroutineContext is ${this@gl.coroutineContext}")
//            job1.cancel()
//        }
//        println("end|${Thread.currentThread()}")
//    }
//
//    Thread.sleep(7000L)
//    println("${job.children.count()}|job = ${job}")
//}



/**
 * 正常取消
 */
//fun main() = runBlocking {
//    println("start|${Thread.currentThread()}")
//    val job1 = launch() {
//        yield()
//        println("job1|start|coroutineContext = ${coroutineContext}")
//        println("runBlocking@coroutineContext is ${this@runBlocking.coroutineContext}")
//        val start = System.currentTimeMillis()
//        while (true) {
//            if (System.currentTimeMillis() - start > 6000L) break
//        }
//        println("job1|end|coroutineContext = ${coroutineContext}")
//        println("runBlocking@coroutineContext is ${this@runBlocking.coroutineContext}")
//    }
//
//    val job2 = launch() {
//        println("job2|start|coroutineContext = ${coroutineContext}")
//        val start = System.currentTimeMillis()
//        while (true) {
//            if (System.currentTimeMillis() - start > 3000L) break
//        }
//        println("job2|end|coroutineContext = ${coroutineContext}")
//        println("runBlocking@coroutineContext is ${this@runBlocking.coroutineContext}")
//        cancel()
//        println("job2|coroutineContext = ${coroutineContext}")
//        println("runBlocking@coroutineContext is ${this@runBlocking.coroutineContext}")
//    }
//    println("end|${Thread.currentThread()}")
//}


/**
 * 取消检查
 */
//fun main() {
//    //方式一
////    runBlocking(Dispatchers.Default) {
////        println("start|${System.currentTimeMillis()}|$this")
////
////        val job = launch {
////            println("job|start|${System.currentTimeMillis()}|$this")
////            val start = System.currentTimeMillis()
////            while (isActive) {
////                if (System.currentTimeMillis() - start > 3000L) break
////            }
////            println("job|end|${System.currentTimeMillis()}|$this")
////        }
////
////        job.cancel()
////        println("end|${System.currentTimeMillis()}|$this")
////    }
//
//    //方式二
//    runBlocking{
//        println("start|${System.currentTimeMillis()}|$this")
//
//        val job = launch {
//            println("job|start|${System.currentTimeMillis()}|$this")
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 3000L) break
//                yield()
//            }
//            println("job|end|${System.currentTimeMillis()}|$this")
//        }
//
//        delay(100L)
//        job.cancel()
//        println("end|${System.currentTimeMillis()}|$this")
//    }
//}



/**
 * 取消异常处理
 */
//fun main() {
//    //使用finally代码块
////    runBlocking {
////        val job = launch {
////            try {
////                repeat(1000) { i ->
////                    println("job: I'm sleeping $i ...")
////                    delay(500L)
////                }
////            } finally {
////                delay(1000L)
////                println("job: I'm running finally")
////            }
////        }
////        delay(1300L) // delay a bit
////        println("main: I'm tired of waiting!")
//////        job.cancel() // cancels the job and waits for its completion
////        job.cancelAndJoin() // cancels the job and waits for its completion
////        println("main: Now I can quit.")
////    }
//
//
//    //使用finally代码块
//    runBlocking {
//        val job = launch {
//            try {
//                repeat(5) { i ->
//                    println("[job]I'm sleeping $i ...")
//                    delay(1000L)
//                }
//            } finally {
////                delay(1000L)
//                launch { println("[job|finally|launch again!]") }
//                println("[job]finally!")
//            }
//        }
//        delay(3000L)
//        job.cancel()
//    }
//
//}



/**
 * 监控任务
 */
fun main() = runBlocking {
    val supervisor = SupervisorJob()
    with(CoroutineScope(coroutineContext + supervisor)) {
        // launch the first child -- its exception is ignored for this example (don't do this in practice!)
        val firstChild = launch(CoroutineExceptionHandler { _, _ ->  }) {
            println("The first child is failing")
            throw AssertionError("The first child is cancelled")
        }
        // launch the second child
        val secondChild = launch {
            firstChild.join()
            // Cancellation of the first child is not propagated to the second child
            println("The first child is cancelled: ${firstChild.isCancelled}, but the second one is still active")
            try {
                delay(Long.MAX_VALUE)
            } finally {
                // But cancellation of the supervisor is propagated
                println("The second child is cancelled because the supervisor was cancelled")
            }
        }
        // wait until the first child fails & completes
        firstChild.join()
        println("Cancelling the supervisor")
        supervisor.cancel()
        secondChild.join()
    }
}