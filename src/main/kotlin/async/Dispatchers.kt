package async

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

/**
 * Created by Administrator on 2021/8/1.
 */
fun doWork(n:Long = 1000) {
    val start = System.currentTimeMillis()
    while (true) {
        if (System.currentTimeMillis() - start > n) break
    }
}
//fun main() {
//    //方式一
////    thread {
////        println(Thread.currentThread())
////        runBlocking {
////            println("runBlocking|" + Thread.currentThread())
////            launch {
////                println("launch|null|" + Thread.currentThread())
////                doWork()
////            }
////            launch(context = Dispatchers.Unconfined) {
////                println("launch|Unconfined|" + Thread.currentThread())
////                val start = System.currentTimeMillis()
////                doWork()
////            }
////            launch(context = Dispatchers.Default) {
////                println("launch|Default|" + Thread.currentThread())
////                val start = System.currentTimeMillis()
////                while (true) {
////                    if (System.currentTimeMillis() - start > 3000L) break
////                }
////            }
////            launch(context = Dispatchers.IO) {
////                println("launch|IO|" + Thread.currentThread())
////                val start = System.currentTimeMillis()
////                doWork()
////            }
////
//////            launch(context = Dispatchers.Main) {//报错，估计要在android中使用
//////                println("launch|Main|" + Thread.currentThread())
//////            }
////
////        }
////    }
//
//
//    //方式二
//    thread {
//        println(Thread.currentThread())
//        runBlocking {
//            println("runBlocking|" + Thread.currentThread())
//            launch(context = newSingleThreadContext("xx")) {
//                println("launch|newSingleThreadContext|" + Thread.currentThread())
//
//            }
//            launch(context = newFixedThreadPoolContext(1, "yy")) {
//                println("launch|newSingleThreadContext|" + Thread.currentThread())
//            }
//
//        }
//
//    }
//}

/**
 * 指定分发器
 */
//fun main() = runBlocking(context = Dispatchers.Default) {
//    println("start|${Thread.currentThread()}")
//
//    launch{
//        println("job1|start|${Thread.currentThread()}")
//        delay(1000L)
//        println("job1|end|${Thread.currentThread()}")
//    }
//    launch{
//        println("job2|start|${Thread.currentThread()}")
//        delay(1000L)
//        println("job2|end|${Thread.currentThread()}")
//    }
//
//    println("end|${Thread.currentThread()}")
//}


/**
 * 使用本地线程
 */
//val threadLocal = ThreadLocal<String?>() // declare thread-local variable
//fun main() = runBlocking<Unit> {
//    threadLocal.set("main")
//    println("Pre-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
//    val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "launch")) {
//        println("Launch start, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
//        yield()
//        println("After yield, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
//    }
//    job.join()
//    println("Post-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
//}

/**
 * 使用锁
 */
//fun main() = runBlocking(Dispatchers.Default) {
//    val mutex = Mutex()
//    println("start")
//
//    launch {
//        println("[job1]start|$this|${Thread.currentThread()}|${System.currentTimeMillis()}")
//        mutex.lock()
//        val start = System.currentTimeMillis()
//        while (true) {
//            if (System.currentTimeMillis() - start > 4000L) break
//        }
//        mutex.unlock()
//        println("[job1]end|$this|${Thread.currentThread()}|${System.currentTimeMillis()}")
//    }
//
//    launch {
//        println("[job2]start|$this|${Thread.currentThread()}|${System.currentTimeMillis()}")
//        mutex.lock()
//        val start = System.currentTimeMillis()
//        while (true) {
//            if (System.currentTimeMillis() - start > 4000L) break
//        }
//        mutex.unlock()
//        println("[job2]end|$this|${Thread.currentThread()}|${System.currentTimeMillis()}")
//    }
//
//    repeat(10) {
//        launch {
//            println("[repeat-job-$it]$this|${Thread.currentThread()}|${System.currentTimeMillis()}")
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 500L) break
//            }
//        }
//    }
//
//    println("end")
//}


/**
 * 使用锁同步变量
 */
//fun main() = runBlocking(Dispatchers.Default) {
//    val mutex = Mutex()
//    println("mutex = ${mutex}")
//    val id = 0
//
//    println("start")
//
//    launch {
//        println("[job1]start|$this|${Thread.currentThread()}|${System.currentTimeMillis()}")
//        mutex.lock(id)
//        val start = System.currentTimeMillis()
//        while (true) {
//            if (System.currentTimeMillis() - start > 4000L) break
//        }
//        println("mutex = ${mutex}")
//        mutex.unlock(id)
//        println("[job1]end|$this|${Thread.currentThread()}|${System.currentTimeMillis()}")
//    }
//
//    launch {
//        println("[job2]start|$this|${Thread.currentThread()}|${System.currentTimeMillis()}")
//        mutex.lock(id+1)
//        val start = System.currentTimeMillis()
//        while (true) {
//            if (System.currentTimeMillis() - start > 4000L) break
//        }
//        mutex.unlock(id+1)
//        println("[job2]end|$this|${Thread.currentThread()}|${System.currentTimeMillis()}")
//    }
//
//    println("end")
//}


/**
 * 使用扩展函数加锁
 */
//fun main() = runBlocking(Dispatchers.Default) {
//    val mutex = Mutex()
//
//    println("start")
//
//    launch {
//        println("[job1]start|$this|${Thread.currentThread()}|${System.currentTimeMillis()}")
//        mutex.withLock {
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 4000L) break
//            }
//        }
//        println("[job1]end|$this|${Thread.currentThread()}|${System.currentTimeMillis()}")
//    }
//
//    launch {
//        println("[job2]start|$this|${Thread.currentThread()}|${System.currentTimeMillis()}")
//        mutex.withLock {
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 4000L) break
//            }
//        }
//        println("[job2]end|$this|${Thread.currentThread()}|${System.currentTimeMillis()}")
//    }
//
//    println("end")
//
//}


/**
 * 使用Actor
 */
//fun main() = runBlocking {
//
//    val sendC: SendChannel<Array<Int>> = actor(capacity = 6) {
//        var count = 0
//        println("$this|${Thread.currentThread()}")
//        for (n in channel) {
//            println("n = ${n}")
//            count = n[0]
//            n[1] = count+1
//        }
//    }
//
//    val array: Array<Int> = arrayOf(9,0)
//    array.forEach { println("it is $it") }
//    sendC.send(array)
//
//    delay(1000L)
//    array.forEach { println("it is $it") }
//}


/**
 * 多Actor
 */
fun main() = runBlocking {
    val send1: SendChannel<Int>
    var send2: SendChannel<Int>? = null

    send1 = actor(capacity = 6) {
        println("$this|${Thread.currentThread()}")

        for (n in channel) {
            println("send1|n = ${n}")
            send2?.send(9)
        }

    }

    send2 = actor(capacity = 6) {
        println("$this|${Thread.currentThread()}")

        send1.send(1)
        for (n in channel) {
            println("send2|n = ${n}")
        }
    }

}