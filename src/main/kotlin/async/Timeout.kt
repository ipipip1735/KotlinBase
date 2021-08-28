package async

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.system.measureTimeMillis

/**
 * Created by Administrator on 2021/7/29.
 */
fun main() = runBlocking {

    //使用Timeout
//    withTimeout(3000L) {
//        val start = System.currentTimeMillis()
//        println("start|$start")
//        while (System.currentTimeMillis() - start < 5000L) yield()
//        println("end|${System.currentTimeMillis()}")
//    }

    //使用TimeoutOrNull
    val r = withTimeoutOrNull(3000L) {
        val start = System.currentTimeMillis()
        println("start|$start")
        while (System.currentTimeMillis() - start < 5000L) yield()
        println("end|${System.currentTimeMillis()}")
    }

    println("r = ${r}|${java.lang.System.currentTimeMillis()}")
}
