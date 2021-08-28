package async


import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import java.util.*

/**
 * Created by Administrator on 2021/8/17.
 */
/**
 * Flow构建器
 */
//fun main() {
//    //使用flow()
////    val flow:Flow<Int>  =  flow {
////        for (i in 1..3) {
////            println("i = ${i}")
////            emit(i)
////        }
////    }
////    runBlocking {
////        flow.collect()
////    }
//
//    //使用flowOf()
////    val flow: Flow<Int> = flowOf(1, 2, 4, 5)
////    runBlocking {
////        flow.collect{
////            println("it = ${it}")
////        }
////    }
//
//    //使用asFlow()
//    val flow: Flow<Int> = (1..3).asFlow()
//    runBlocking {
//        flow.collect { value -> println(value) }
//    }
//}


/**
 * 指定执行线程
 */
////fun main() = runBlocking(Dispatchers.Unconfined) {
//fun main() = runBlocking {
//
//    flow<Int> {
//        println("${Thread.currentThread()}")
//        for (i in 1..3) {
//            println("start|emit|${java.lang.Thread.currentThread()}")
//            emit(i)
//            println("end|emit|${java.lang.Thread.currentThread()}")
//        }
//    }
//        .map { v ->
//            println("map|$v|${Thread.currentThread()}");v * 2
//        }
//        .flowOn(Dispatchers.Default)
//        .filter { unit ->
//            println("filter|$unit|${Thread.currentThread()}")
//            true
//        }
////        .flowOn(Dispatchers.IO)
//        .collect { println("collect|$it|${Thread.currentThread()}") }
//}


/**
 * 使用钩子函数
 */
//fun main() = runBlocking {
//    //方式一
////    println("start")
////    flow {
////        println("${Thread.currentThread()}")
////        for (i in 1..3) emit(i)
////    }
////        .onCompletion { println("onCompletion0|$this") }
////        .onStart { println("onStart1|$this") }
////        .onStart { println("onStart2|$this") }
////        .onCompletion { println("onCompletion1|$this") }
////        .map { println("map|$it|$this");it }
////        .onEach { println("onEach2|$it|$this") }
////        .filter { println("filter|$it|$this");true }
////        .onStart { println("onStart3|$this") }
////        .onEach { println("onEach3|$it|$this") }
////        .onCompletion { println("onCompletion2|$this") }
////        .collect {
////            println("it is $it")
////        }
////    println("end")
//
//    //方式二
//    println("start")
//    emptyFlow<Int>().onEmpty {
//        emit(1)
//        emit(2)
//    }.collect { println(it) }
//}


/**
 * 使用buffer
 */
//fun main() = runBlocking {
//    flow {
//        println("${Thread.currentThread()}")
//        for (i in 1..4) emit(i)
//    }
//        .onEach { println("onEach|$it|$this") }
//        .buffer(1, BufferOverflow.DROP_LATEST)
//        .collect {
//            println("$it|${java.lang.Thread.currentThread()}")
//            delay(5000L)
//        }
//}

/**
 * 使用conflate
 */
//fun main() = runBlocking {
//    flow {
//        println("${Thread.currentThread()}")
//        for (i in 1..4){
//            emit(i)
//        }
//    }
//        .onEach { println("onEach|$it|$this") }
//        .conflate()
//        .collect {
//            println("$it|${java.lang.Thread.currentThread()}")
////            delay(100L)
//        }
//}


/**
 * 使用xxxLatest
 */
////fun main() = runBlocking {
////    flow {
////        println("${Thread.currentThread()}")
////        for (i in 1..3) {
////            println("start|emit|${java.lang.Thread.currentThread()}")
////            emit(i)
////            println("end|emit|${java.lang.Thread.currentThread()}")
////        }
////    }
////        .onEach { println("onEach|$it|$this") }
////        .collectLatest {
////            println("s|$it|${java.lang.Thread.currentThread()}")
////            yield()
////            println("e|$it|${java.lang.Thread.currentThread()}")
////        }
////}
//
//fun main() = runBlocking {
//    flow {
//        println("${Thread.currentThread()}")
//        for (i in 1..3) {
//            println("start|emit|${java.lang.Thread.currentThread()}")
//            emit(i)
//            val start = System.currentTimeMillis()
//            while (true) {
//                if (System.currentTimeMillis() - start > 3000L) break
//            }
//            println("end|emit|${java.lang.Thread.currentThread()}")
//        }
//    }
//        .mapLatest {
////            println("map1|$it|${java.lang.Thread.currentThread()}")
////            it * 2
//            yield()
//            println("map2|$it|${java.lang.Thread.currentThread()}-----")
//            it * 3
//        }
//        .collect {
//            println("collect|$it|${java.lang.Thread.currentThread()}")
//        }
//}

/**
 * 合并
 */
//fun main() = runBlocking {
//    flow {
//        println("${Thread.currentThread()}")
//        for (i in 1..3) {
//            println("start|emit")
//            emit(i)
//            println("end|emit")
//        }
//    }
//        .flatMapConcat {
//            flow {
//                emit("$it|1")
//                emit("$it|2")
//            }
//        }
//        .collect {
//            println("collect|$it|${java.lang.Thread.currentThread()}")
//        }
//}

//fun main() = runBlocking {
//    flow {
//        println("${Thread.currentThread()}")
//        for (i in 1..3) {
//            println("start|emit")
//            emit(i)
//            println("end|emit")
//        }
//    }
//        .flatMapMerge(2) {
//            flow {
//                emit("$it|1")
//                yield()
//                emit("$it|2")
//            }
//        }
//        .collect {
//            println("collect|$it|${java.lang.Thread.currentThread()}")
//        }
//}

//fun main() = runBlocking {
//    flow {
//        println("${Thread.currentThread()}")
//        for (i in 1..3) {
//            println("start|emit")
//            emit(i)
//            println("end|emit")
//        }
//    }
//        .flatMapLatest() {
//            yield()
//            flow {
//                emit("$it|1")
//                emit("$it|2")
//            }
//        }
//        .collect {
//            println("collect|$it|${java.lang.Thread.currentThread()}")
//        }
//}


/**
 * 异常处理
 */
//fun main() = runBlocking {
//    flow {
//        println("${Thread.currentThread()}")
//        for (i in 1..3) {
//            println("start|emit")
//            emit(i)
//            println("end|emit")
//        }
//
//        throw Exception()
//    }
//        .catch { println("catch|$this|$it") }
//        .onCompletion { println("onCompletion|$this|$it") }
//        .collect {
//            println("collect|$it|${java.lang.Thread.currentThread()}")
//        }
//}


/**
 * 取消
 */
fun main() = runBlocking {
    flow {
        println("${Thread.currentThread()}")
        for (i in 1..3) {
            println("start|emit")
            emit(i)
            println("end|emit")
        }
    }
        .catch { println("catch|$this|$it") }
        .collect {
            if (it == 2) cancel()
            println("collect|$it|${java.lang.Thread.currentThread()}")
        }
}