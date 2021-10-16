package syntax

/**
 * Created by Administrator on 2021/6/25.
 */
fun main() {
    //扩展函数泛型
//    extenerFun()

    //变体（方式一）
//    var zeroGI: ZeroGI<TwoG>
//    zeroGI = OneZG()//逆变
//    zeroGI.show(OneG())

//    var zeroGO: ZeroGO<ThreeG>
//    zeroGO = FourZG()//协变
//    zeroGO.see()

    //变体（方式二）
//    var k1: ZeroGI<OneG> = object : ZeroGI<OneG> {
//        override fun show(t: OneG) {
//        }
//    }
//    var k2: ZeroGI<TwoG> = object : ZeroGI<TwoG> {
//        override fun show(t: TwoG) {
//        }
//
//    }
//    k2 = k1 //逆变

    var k1: VoidGI<OneG> = object : VoidGI<OneG> {
        override fun result(): OneG {
            return OneG()
        }
    }
    var k2: VoidGI<TwoG> = object : VoidGI<TwoG> {
        override fun result(): TwoG {
            return TwoG()
        }
    }
    k1 = k2 //协变



    //投影
//    val ints: Array<Int> = arrayOf(1, 2, 3)
//    val any = Array<Any>(3) { "" }
//    copy(ints, any)//协变投影

//    val any: Array<String> = arrayOf("aa", "bb", "cc")
//    val strings = Array<CharSequence>(3) { "" }
//    fill(strings, any)//逆变投影


    //星号投影
//    val tp: TwoProject<*> = TwoProject<TwoGe>()
//    val oneGe: OneGe = tp.getT()


}


/**
 * 扩展函数泛型
 */
private fun extenerFun() {
    "xxx".eee()
    1.eee()
    3.4f.eee()
    String.eee()
    Float.eee()
}

fun <T> T.eee() {
    println("this = ${this}")
}


/**
 * 变体
 */
//协变
interface OneGI<out T> {
    fun show(): T
}

//逆变
interface TwoGI<in T> {
    fun show(t: T)
}

open class OneG
class TwoG : OneG()
interface ZeroGI<in T> {
    fun show(t: T)
}

interface VoidGI<out T> {
    fun result(): T
}

class OneZG : ZeroGI<OneG> {
    override fun show(t: OneG) {
        println("OneZG|t = ${t}")
    }
}

class TwoZG : ZeroGI<TwoG> {
    override fun show(t: TwoG) {
        println("TwoZG|t = ${t}")
    }
}


open class ThreeG
class FourG : ThreeG()
interface ZeroGO<out T> {
    fun see(): T
}

class ThreeZG : ZeroGO<ThreeG> {
    override fun see(): ThreeG {
        println("ThreeZG(.see")
        return ThreeG()
    }
}

class FourZG : ZeroGO<FourG> {
    override fun see(): FourG {
        println("ZeroGO|FourZG.see")
        return FourG()
    }
}

/**
 * 投影
 */
fun copy(from: Array<out Any>, to: Array<Any>) {
    for (i in from.indices) {
        to[i] = from[i]
    }
//    from.set(0, 3)
//    from[0] = 1
}

fun fill(dest: Array<in String>, src: Array<String>) {
    for (i in src.indices) {
        dest.set(i, src[i])
    }
    for (i in dest.indices) println("dest = ${dest[i]}")
}


open class OneGe
class TwoGe : OneGe()
class ThreeGe : OneGe()
class TwoProject<out T : OneGe> {
    fun getT(): T {
        return TwoGe() as T
    }
}