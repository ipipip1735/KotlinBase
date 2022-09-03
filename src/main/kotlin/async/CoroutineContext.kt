package async

import kotlinx.coroutines.*
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Created by Administrator on 2021/8/1.
 */
/**
 * 任务链
 */
//fun main() = runBlocking {
//    println("coroutineContext = ${coroutineContext}")
//
//    val job = launch {
//        println("Job|coroutineContext = ${coroutineContext}")
//        println("Job|coroutineContext.job.count() = ${coroutineContext.job.children.count()}")
//        launch {
//            println("SubJob|coroutineContext = ${coroutineContext}")
//        }
//        println("Job|coroutineContext.job.count() = ${coroutineContext.job.children.count()}")
//    }
//    println("coroutineContext.job.count() = ${coroutineContext.job.children.count()}")
//}


/**
 * 更改上下文
 */
//fun main() = runBlocking {
//
//    println("coroutineContext = ${coroutineContext}")
//
//    GlobalScope.launch {
//        println("start|coroutineContext = ${coroutineContext}")
//        val start = System.currentTimeMillis()
//        while (true) {
//            if (System.currentTimeMillis() - start > 3000L) break
//        }
//        println("end|coroutineContext = ${coroutineContext}")
//
//    }
//    println("coroutineContext.job.count() = ${coroutineContext.job.children.count()}")
//}


/**
 * 切换上下文
 */
//fun main() = runBlocking {
//    println("coroutineContext = ${coroutineContext}|${java.lang.Thread.currentThread()}")
//
//    //方式一：局部部切换
//    launch {
//        println("start|coroutineContext = ${coroutineContext}|${java.lang.Thread.currentThread()}")
//        withContext(coroutineContext) {
//            println("withContext|coroutineContext = ${coroutineContext}|${java.lang.Thread.currentThread()}")
//        }
//        println("end|coroutineContext = ${coroutineContext}|${java.lang.Thread.currentThread()}")
//
//    }
//
//
//    //方式二：整体切换
//    launch(Dispatchers.IO) {
//        println("withContext|coroutineContext = ${coroutineContext}|${java.lang.Thread.currentThread()}")
//    }
//    println("coroutineContext.job.count() = ${coroutineContext.job.children.count()}|${java.lang.Thread.currentThread()}")
//}

/**
 * 更改Job
 */
//fun main() = runBlocking {
//    println("coroutineContext = ${coroutineContext}")
//
//    launch(context = Job()) {
//        println("job1|start|coroutineContext = ${coroutineContext}")
//        val start = System.currentTimeMillis()
//        while (true) {
//            if (System.currentTimeMillis() - start > 3000L) break
//        }
//        println("job1|end|coroutineContext = ${coroutineContext}")
//
//    }
//    launch() {
//        println("job2|start|coroutineContext = ${coroutineContext}")
//        val start = System.currentTimeMillis()
//        while (true) {
//            if (System.currentTimeMillis() - start > 3000L) break
//        }
//        println("job2|end|coroutineContext = ${coroutineContext}")
//
//    }
//    println("coroutineContext.job.count() = ${coroutineContext.job.children.count()}")
//}


/**
 * 自定义上下文
 */
class OneKey : CoroutineContext.Key<OneElement>
class OneElement : CoroutineContext.Element {
    val i = 99
    override val key: CoroutineContext.Key<OneElement> = OneKey()
}

class OneCoroutineContext(val age: Int) : AbstractCoroutineContextElement(OneCoroutineContext) {
    companion object Key : CoroutineContext.Key<OneCoroutineContext>
}

//fun main() {
//    //方式一：使用Element接口
////    val oneElement = OneElement()
////    println(oneElement.get(oneElement.key))
////    println(oneElement[oneElement.key])
////    println("i = ${oneElement[oneElement.key]?.i}")
////
////    val comb = EmptyCoroutineContext + oneElement
////    println(comb.get(oneElement.key))
////    println(comb[oneElement.key])
////    println("i = ${comb[oneElement.key]?.i}")
//
//    //方式二：使用AbstractCoroutineContextElement抽象类
////    val context: CoroutineContext = EmptyCoroutineContext + OneCoroutineContext(99)
////    println("context[OneCoroutineContext] = ${context[OneCoroutineContext]?.age}")
//
//    //方式三：使用扩展函数
//    val c = GlobalScope.newCoroutineContext(OneCoroutineContext(9))//新建上下文，并增加分发器
//    println("c = ${c}")
//}

/**
 * 访问链
 */
//fun main() = runBlocking {
//
//    println("this = ${this}")
//    println("this.coroutineContext = ${this.coroutineContext}")
//    println("this.coroutineContext.job = ${this.coroutineContext.job}|${this.coroutineContext.job.children.count()}")
//
//    val job = async {
//        println("job|this = ${this}")
//        println("job|this.coroutineContext = ${this.coroutineContext}")
//        println("job|this.coroutineContext.job = ${this.coroutineContext.job}")
//    }
//    println("job = ${job}")
//    println("this.coroutineContext.job = ${this.coroutineContext[Job]}|${this.coroutineContext.job.children.count()}")
//}