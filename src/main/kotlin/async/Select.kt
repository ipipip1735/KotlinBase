package async

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.selects.select

/**
 * Created by Administrator on 2021/8/23.
 */
/**
 * 使用选择器
 */
fun main() = runBlocking {

    val p = produce<Int> {
//    val p = produce<Int>(capacity = 3) {
        repeat(6) {
            println("$it|b")
            send(it)
            println("$it|e")
        }
    }

    println("start")
    repeat(10) {
        if (p.isClosedForReceive)return@repeat
        select<Unit> {
            println("p|it = ${it}, p.isClosedForReceive = ${p.isClosedForReceive}, ${java.lang.Thread.currentThread()}")
            p.onReceive {
                println("p|it = ${it}, p.isEmpty = ${p.isEmpty}, ${java.lang.Thread.currentThread()}")
            }
        }
        yield()
    }

    println("stop|p.isClosedForReceive = ${p.isClosedForReceive}")
}

//fun main() = runBlocking {
//
//    val p0 = produce<Int> {
//        repeat(2) {
//            println("$it|b")
//            send(it)
//            println("$it|e")
//        }
//    }
//    val p1 = produce<Int> {
//        repeat(5) {
//            send(it)
//        }
//    }
//    val p2 = produce<Int> {
//        repeat(5) {
//            send(it)
//        }
//    }
//
//
//
//    println("start")
//    //方式一：使用while
//    while (!p0.isClosedForReceive || !p1.isClosedForReceive || !p2.isClosedForReceive) {
//        select<Unit> {
//            println("p0.isClosedForReceive = ${p0.isClosedForReceive}")
//
//            if (!p0.isClosedForReceive) {
//                p0.onReceive {
//                    println("p0|it = ${it}, p0.isEmpty = ${p0.isEmpty}, p0.isClosedForReceive = ${p0.isClosedForReceive}")
//                }
//            }
//
//            if (!p1.isClosedForReceive) {
//                p1.onReceive {
//                    println("p1|it = ${it}")
//                }
//            }
//
//            if (!p2.isClosedForReceive) {
//                p2.onReceive {
//                    println("p2|it = ${it}")
//                }
//            }
//
//        }
//        yield()
//        println("yield")
//    }
//
//    //方式二：使用repeat
////    repeat(23) {
////        select<Unit> {
////            println("p0.isClosedForReceive = ${p0.isClosedForReceive}")
////            if (!p0.isClosedForReceive) {
////                p0.onReceive {
////                    println("p0|it = ${it}, p0.isEmpty = ${p0.isEmpty}, p0.isClosedForReceive = ${p0.isClosedForReceive}")
////                }
////            }
////
////            if (!p1.isClosedForReceive) {
////                p1.onReceive {
////                    println("p1|it = ${it}")
////                }
////            }
////
////            if (!p2.isClosedForReceive) {
////                p2.onReceive {
////                    println("p2|it = ${it}")
////                }
////            }
////
////        }
////        yield()
////    }
//
////    select<Unit> {
////
////        println("p0.isClosedForReceive = ${p0.isClosedForReceive}")
//////        p0.onReceive {
//////            println("p0|it = ${it}, p0.isEmpty = ${p0.isEmpty}, p0.isClosedForReceive = ${p0.isClosedForReceive}")
//////        }
////    }
//    println("stop")
//}


/**
 * 使用onReceive
 */
//fun main() = runBlocking {
//
//    //创建3个生产者
//    val p1 = produce<Int> {
//        repeat(3) {
//            send(it)
//        }
//    }
//    val p2 = produce {
//        repeat(3) {
//            send(it)
//        }
//    }
//    val p3 = produce {
//        repeat(3) {
//            send(it)
//        }
//    }
//
//    repeat(1) {
//        println("------------$it|start")
//        //创建选择器
//        select<Unit> { /*优先选择第一个分句，其他分句只有在第一个分句无法执行时才会执行*/
////        selectUnbiased<Unit> { /*公平选择器，完全随机选择*/
//            println("repeat$it|1")
//            p1.onReceive { v ->
//                val start = System.currentTimeMillis()
//                while (true) {
//                    if (System.currentTimeMillis() - start > 1000L) break
//                }
//                println("p1.onReceive|it = ${it}|v = $v|${Thread.currentThread()}")
//            }
//            println("repeat$it|2")
//            p2.onReceive { v ->
//                val start = System.currentTimeMillis()
//                while (true) {
//                    if (System.currentTimeMillis() - start > 1000L) break
//                }
//                println("p2.onReceive|it = ${it}|v = $v|${Thread.currentThread()}")
//
//            }
//            println("repeat$it|3")
//            p3.onReceive { v ->
//                val start = System.currentTimeMillis()
//                while (true) {
//                    if (System.currentTimeMillis() - start > 1000L) break
//                }
//                println("p3.onReceive|it = ${it}|v = $v|${Thread.currentThread()}")
//
//            }
//            println("repeat$it|4")
//        }
//        println("------------$it|end")
//    }
//
//}


/**
 * 使用onReceiveCatching
 */
//fun main() = runBlocking {
//
//    println("runBlocking|start")
//    val p1 = produce<Int> {
//        repeat(20) {
//            send(it)
//        }
//    }
//
//    val p2 = produce {
//        repeat(3) {
//            send(it)
//        }
//    }
//
//    repeat(40) {
//        println("------------$it|start")
//        select<Unit> {
//            println("repeat$it|1")
//            if (!p1.isClosedForReceive) p1.onReceiveCatching { v ->
//                println("p1.onReceiveCatching|it = ${it}|v = $v|${Thread.currentThread()}")
//            }
//            println("repeat$it|2")
//            if (!p2.isClosedForReceive) p2.onReceive { v ->
//                println("p2.onReceive|it = ${it}|v = $v|${Thread.currentThread()}")
//            }
//            println("repeat$it|3")
//        }
//        println("------------$it|end")
//    }
//
//    println("runBlocking|end")
//}


/**
 * 使用onSend
 */
//fun main() = runBlocking {
//    println("start")
//    val channel1 = Channel<Int>()
//    val channel2 = Channel<Int>()
//    val channel3 = Channel<Int>()
//
//    launch {
//        channel1.consumeEach {
//            println("consumeEach1|$it")
//            doWork()
//        }
//    }
//    launch {
//        channel2.consumeEach { println("consumeEach2|$it")
//            doWork()
//        }
//    }
//    launch {
//        channel3.consumeEach { println("consumeEach3|$it")
//            doWork()
//        }
//    }
//
//    repeat(5) { n ->
//        println("repeat|$n|start----------")
//        select<Unit> {
//            channel1.onSend(n) {
//                println("onSend1|$n|$it")
//            }
//            channel2.onSend(n) {
//                println("onSend2|$n|$it")
//            }
//            channel3.onSend(n) {
//                println("onSend3|$n|$it")
//            }
//        }
//        println("repeat|$n|end----------")
//    }
//    channel1.close()
//    channel2.close()
//    channel3.close()
//
//    println("end")
//}


/**
 * 使用onWaiting
 */
//fun main() = runBlocking {
//    println("start|${System.currentTimeMillis()}")
//    val list = List(3) {
//        async {
//            delay(if (it == 1) 1000 else 6000)
//            "$it - List - ${System.currentTimeMillis()}"
//        }
//    }
//
//    val result = select<String> {
//
//        list.withIndex()
//            .forEach { (index, e) ->
//                println("forEach$index|start")
//                e.onAwait {
//                    println("onAwait|start|it = $it, index = $index, e = $e|${System.currentTimeMillis()}")
//                    val r = "onAwait|$index|$e|$it"
//                    println("r = $r")
//                    println("onAwait|end|it = $it, index = $index, e = $e|${System.currentTimeMillis()}")
//                    "$r - select"
//                }
//
//                println("forEach$index|end")
//            }
//
//    }
//    println("result = ${result}")
//
//    println("end|${System.currentTimeMillis()}")
//}


/**
 * 使用onSend
 */
//fun main() = runBlocking {
//    println("start")
//
//    val channel = Channel<Deferred<String>>()
//    launch {
//        println("launch|start")
//        var current = channel.receive()
//
//        while (isActive) {
//            val r = select<Deferred<String>?> {
//                current.onAwait {
//                    println("onAwait|$it")
//                    channel.receive()
//                }
//                channel.onReceiveCatching {
//                    println("onReceiveCatching|$it")
//                    it.getOrNull()
//                }
//
//            }
//            println("r = ${r}")
//            if (r == null) break else current = r
//        }
//        println("launch|end")
//    }
//
//    repeat(4) {
//        channel.send(async {
////            delay(if(it == 2)100L else 6000L)
//            "$it - deferred"
//        }
//        )
//    }
//    channel.close()
//
//    println("end")
//}