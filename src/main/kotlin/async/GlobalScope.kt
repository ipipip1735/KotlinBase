package async

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce
import kotlin.concurrent.thread
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.system.measureTimeMillis

/**
 * Created by Administrator on 2021/8/1.
 */
/**
 * 简单使用
 */
//fun main() {
//    //方式一
////    repeat(5) {
//////        GlobalScope.launch {
//////            println("start|$this|${Thread.currentThread()}")
//////            delay(1000L)
//////            println("end|$this|${Thread.currentThread()}")
//////        }
////
//////        CoroutineScope(EmptyCoroutineContext).launch {
//////            println("start|$this|${Thread.currentThread().name}")
//////            delay(1000L)
//////            println("end|$this|${Thread.currentThread().name}")
//////        }
////
////    }
////    Thread.sleep(2000L)
//
//
//    //方式二
////    val deferred = oneA()
////    println("deferred = ${deferred}")
//
//
//    //方式三
////    println("start")
////    thread {
////        println(Thread.currentThread())
////        val deferred = oneA()
////        println("deferred = ${deferred}")
////        runBlocking {
////            println("runBlocking|" + Thread.currentThread())
////            deferred.await()
////        }
////    }
////    println("end")
//
//
//    //方法四
////    GlobalScope.launch() {
////        println("~~GlobalScope.launch~~")
////
////        println("1|this = ${this}")
////        println("1|this = ${this.coroutineContext}")
////    }
////
////    GlobalScope.launch {
////        println("~~GlobalScope.launch~~")
////        delay(2000L)
////        println("2|this = ${this}")
////        println("2|this = ${this.coroutineContext}")
////    }
////    Thread.sleep(5000L)
//}


fun oneA() = GlobalScope.async {
    println("oneA|" + Thread.currentThread())
    show()
}

suspend fun show() {
    println("~~show~~")
    delay(2000L)
    println("async|" + Thread.currentThread())
}


/**
 * 全局作用域
 */
//fun main() {
//
//    println("start")
//    GlobalScope.launch(Dispatchers.Unconfined) {
////    GlobalScope.launch {
//        launch {
//            println("launch1|start|$this|${Thread.currentThread()}")
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 4000L) break
//            }
//            println("launch1|end|$this|${Thread.currentThread()}")
//        }
//
//        launch {
//            println("launch2|start|$this|${Thread.currentThread()}")
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 6000L) break
//            }
//            println("launch2|end|$this|${Thread.currentThread()}")
//        }
//    }
//
//    println("end")
//    Thread.sleep(5000L)
//}

/**
 * 全局作用域和非限制分发器配合使用
 */
fun main() = runBlocking {
    println("start|${System.currentTimeMillis()}")

    GlobalScope.launch(Dispatchers.Unconfined){
        while (true) {
            delay(1000L)
        }
    }

    println("end|${System.currentTimeMillis()}")
}

/**
 * 作用域协程
 */
//fun main() = runBlocking {
//
//    println("start")
//    coroutineScope {
//        println("[job1]start|$this|${Thread.currentThread()}")
//        val start = System.currentTimeMillis()
//        while (true) {
//            if (System.currentTimeMillis() - start > 4000L) break
//        }
//        println("[job1]end|$this|${Thread.currentThread()}")
//    }
//
//    launch {
//        println("[job2]start|$this|${Thread.currentThread()}")
//        val start = System.currentTimeMillis()
//        while (true) {
//            if (System.currentTimeMillis() - start > 2000L) break
//        }
//        println("[job2]end|$this|${Thread.currentThread()}")
//    }
//
//    println("end")
//    Thread.sleep(5000L)
//    println(coroutineContext.job.children.count())
//}