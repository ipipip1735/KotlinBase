package async

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

/**
 * Created by Administrator on 2021/8/1.
 */
fun main() {

    val s = MainScope()
    MainScope().launch {
        println("go")
        yield()
    }


    val sequence = sequence {
        val start = 0
        // yielding a single value
        yield(start)
        // yielding an iterable
        yieldAll(1..5 step 2)
        // yielding an infinite sequence
        yieldAll(generateSequence(8) { it * 3 })
    }
}




