package async


import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

/**
 * Created by Administrator on 2021/8/19.
 */
/**
 * 使用回合通道
 */
//fun main() {
//    val channel = Channel<Int>(Channel.RENDEZVOUS)
//    //方式一
//    runBlocking {
//        launch {
//            val r = channel.receive()
//            println("r = ${r}")
//        }
//        channel.send(1)
//    }
//
//    //方式二
////    runBlocking {
////        launch {
////            channel.send(1)
////        }
////        val r = channel.receive()
////        println("r = ${r}")
////    }
//}


/**
 * 使用缓冲通道
 */
//fun main() {
//    val channel = Channel<Int>(1)
//    runBlocking {
//        channel.send(1)
//        val r = channel.receive()
//        println("r = ${r}")
//    }
//}


/**
 * 通道状态
 */
//fun main() = runBlocking() {
//    val channel = Channel<Int>(2)
//    println("channel.isEmpty = ${channel.isEmpty}, channel.isClosedForSend = ${channel.isClosedForSend}, channel.isClosedForReceive = ${channel.isClosedForReceive}")
//    launch {
//        println("start|channel.isEmpty = ${channel.isEmpty}, channel.isClosedForSend = ${channel.isClosedForSend}, channel.isClosedForReceive = ${channel.isClosedForReceive}")
//        channel.send(1)
//        println("send1|channel.isEmpty = ${channel.isEmpty}, channel.isClosedForSend = ${channel.isClosedForSend}, channel.isClosedForReceive = ${channel.isClosedForReceive}")
//        channel.send(2)
//        println("send2|channel.isEmpty = ${channel.isEmpty}, channel.isClosedForSend = ${channel.isClosedForSend}, channel.isClosedForReceive = ${channel.isClosedForReceive}")
//        channel.close()
//        println("end|channel.isEmpty = ${channel.isEmpty}, channel.isClosedForSend = ${channel.isClosedForSend}, channel.isClosedForReceive = ${channel.isClosedForReceive}")
//    }
//    println("receive1|channel.isEmpty = ${channel.isEmpty}, channel.isClosedForSend = ${channel.isClosedForSend}, channel.isClosedForReceive = ${channel.isClosedForReceive}")
//    channel.receive()
//    println("receive2|channel.isEmpty = ${channel.isEmpty}, channel.isClosedForSend = ${channel.isClosedForSend}, channel.isClosedForReceive = ${channel.isClosedForReceive}")
//    channel.receive()
//    println("receive3|channel.isEmpty = ${channel.isEmpty}, channel.isClosedForSend = ${channel.isClosedForSend}, channel.isClosedForReceive = ${channel.isClosedForReceive}")
//    channel.receive()
//    println("receive4|channel.isEmpty = ${channel.isEmpty}, channel.isClosedForSend = ${channel.isClosedForSend}, channel.isClosedForReceive = ${channel.isClosedForReceive}")
//}


/**
 * 遍历通道
 */
//fun main() = runBlocking {
//    //方式一
////    val channel = Channel<Int>()
////    launch {
////        for (i in 1..2) {
////            channel.send(i)
////        }
////        channel.close()
////    }
////    while (!channel.isClosedForReceive) {
////        println("channel.receive() = ${channel.receive()}")
////        yield()
////    }
//
//    //方式二
//    val channel = Channel<Int>()
//    launch {
//        for (i in 1..2) {
//            channel.send(i)
//        }
//        channel.close()
//    }
//
//    while (true) {
//        val v = channel.receiveCatching()
//        println("channel.receiveCatching() = $v")
//        println("exceptionOrNull = ${v.exceptionOrNull()}")
//        if (v.getOrNull() == null) break
//    }
//
//
//    //方式三
////    val channel = Channel<Int>()
////    launch {
////        while (!channel.isClosedForReceive) {
////            println("1channel.receive() = ${channel.receive()}")
////            yield()
////        }
////    }
////    for (i in 1..3) channel.send(i)
////    val k = channel.close()
//
//
//    //方式四
////    val channel = Channel<Int>()
////    println("start")
////    launch {
////        for (i in 1..2) {
////            channel.send(i)
////        }
////        channel.close()
////    }
////    launch {
////        while (!channel.isClosedForReceive) {
////            println("channel.receive() = ${channel.receive()}")
////        }
////    }
////    println("end")
//
//
//    //方式五：使用customeEach()
////    val channel = Channel<Int>()
////    launch {
////        repeat(3) { channel.send(it) }
////        channel.close()
////    }
////    channel.consumeEach { println("$it|${channel.isClosedForReceive}") }
//
//
//    //方式六：自动取消
////    val channel = Channel<Int>()
////    launch {
////        repeat(3) { channel.send(it) }
////    }
////    channel.consume {
////        println("receive() = ${receive()}|isClosedForReceive = $isClosedForReceive")
////    }
////    println("receive() = ${channel.receive()}|${channel.isClosedForReceive}")
//}


/**
 * 关闭通道
 */
//fun main() {
//    val channel = Channel<Int>(1)
//    runBlocking {
//        launch {
//            for (i in 1..3) channel.send(i)
//            channel.close()
//        }
//        for (r in channel) println("r = ${r}")
//    }
//}


/**
 * 通道转换
 */
//fun main() = runBlocking {
//    //方式一：导出异步流
////    val channel = Channel<Int>()
////
////    launch {
////        repeat(3) {
////            println("send|start")
////            channel.send(it)
////            println("send|end")
////        }
////        channel.close()
////    }
////
////    channel.consumeAsFlow()
////        .collect{
////        println("flow1|it = ${it}")
////    }
////
////    val start = System.currentTimeMillis()
////    while (true) {
////        if (System.currentTimeMillis() - start > 3000L) break
////    }
////
////    println("-----------")
////    channel.consumeAsFlow()
////        .collect{
////        println("flow2|it = ${it}")
////    }
////    println("end")
//
//
//    //方式二：使用receiveAsFlow()并发接收
//    val channel = Channel<Int>()
//    launch {
//        repeat(4) {
//            println("send$it|start")
//            channel.send(it)
//            println("send$it|end")
//        }
//        channel.close()
//    }
//
//    val flow = channel.receiveAsFlow()
//    launch {
//        flow.collect { v ->
//            println("flow1|v = ${v}")
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 1000L) break
//            }
//        }
//    }
//    launch {
//        flow.collect { v ->
//            println("flow2|v = ${v}")
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 1000L) break
//            }
//        }
//    }
//    println("end")
//}


/**
 * 生产者
 */
fun main() = runBlocking {
    val produce = produce<Int>(capacity = 3) {
        repeat(15) {
            println("${it}|b")
            send(it)
            println("${it}|e")
        }
    }
    yield()
    produce.consumeEach {
        println("${it}|produce.isEmpty = ${produce.isEmpty}, produce.isClosedForReceive = ${produce.isClosedForReceive}")
    }
    yield()
    println("produce.isEmpty = ${produce.isEmpty}, produce.isClosedForReceive = ${produce.isClosedForReceive}")
}

//fun main() = runBlocking {
//
//    val receiveChannel = produce {
//        println("start")
//        for (i in 1..5) send(1)
//        println("end")
//    }
//
//    //方式一
////    receiveChannel.consumeEach {
////        println(it)
////    }
//
//    //方式二
//    for (r in receiveChannel) {
//        println("r = ${r}")
//    }
//}


/**
 * 使用管线
 */
//方式一
//fun main() = runBlocking {
//
//    println("runBlocking|start")
//    val receiveChannel1 = produce(Dispatchers.Default) {
//        println("start1")
//        for (i in 1..3) {
//            println("receiveChannel1|send|start|i = ${i}|${java.lang.Thread.currentThread()}")
//            send(i)
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 1000L) break
//            }
//            println("receiveChannel1|send|end|i = ${i}|${java.lang.Thread.currentThread()}")
//        }
//        println("end1")
//    }
//
//    println("---------------")
//    val receiveChannel2 = produce(Dispatchers.Default) {
//        println("start2")
//        for (i in receiveChannel1) {
//            println("receiveChannel2|send|start|i = ${i}|${java.lang.Thread.currentThread()}")
//            send(i + 100)
//            println("receiveChannel2|send|end|i = ${i}|${java.lang.Thread.currentThread()}")
//        }
//        println("end2")
//    }
//
//    println("---------------")
//    for (r in receiveChannel2) {
//        println("r = ${r}|${java.lang.Thread.currentThread()}")
//    }
//    println("runBlocking|end")
//    coroutineContext.cancelChildren() // cancel children coroutines
//
//}


//方式二
//fun main() {
//    val iterator = iterator<Int> {
//        println("this = ${this}")
//
//        for (i in 1..3) {
//            println("yield|start")
//            yield(i)
////            val start = System.currentTimeMillis()
////            while (true) {
////                if (System.currentTimeMillis() - start > 1000L) break
////            }
//            println("yield|end")
//        }
//    }
//
//    while (iterator.hasNext()) {
//        println("next|start")
//        val r = iterator.next()
//        val start = System.currentTimeMillis()
//        while (true) {
//            if (System.currentTimeMillis() - start > 1000L) break
//        }
//        println("r = ${r}")
//        println("next|end")
//    }
//
//}


/**
 * 扇出
 */
//fun main() = runBlocking {
//    println("start")
//    val producer = produce {
//        repeat(10) {
//            send(it)
//        }
//    }
//
//    repeat(2) {
//        launch {
//            for (r in producer) println("launch$it|r = ${r}")
//        }
//    }
//    println("end")
//
//}

/**
 * 扇入
 */
//fun main() = runBlocking {
//    println("start")
//    val channel = Channel<String>()
//
//    repeat(2) {
//        println("it = ${it}")
//        launch {
//            for (i in it..10 step 2) channel.send("launch$it|$i")
//            if(!channel.isClosedForSend)channel.close()
//        }
//    }
//
//    while (!channel.isClosedForReceive) {
//        println("${channel.receive()}|channel.isClosedForReceive = ${channel.isClosedForReceive}")
//    }
//    println("end")
//
//}


/**
 * 定时通道
 */
//fun main() = runBlocking {
//    println("start|${System.currentTimeMillis()}")
//
////    val ticker = ticker(5000, mode = TickerMode.FIXED_DELAY)
//    val ticker = ticker(3000, mode = TickerMode.FIXED_PERIOD)
//    println("------------")
//    repeat(5) {
//        println("receive|ticker.receive() = ${ticker.receive()}|${System.currentTimeMillis()}")
//        val start = System.currentTimeMillis()
//        while (true) {
//            if (System.currentTimeMillis() - start > 4000L) break
//        }
//    }
////    ticker.cancel()
//
//    println("end|${System.currentTimeMillis()}")
//}