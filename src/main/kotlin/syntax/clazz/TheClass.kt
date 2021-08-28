package syntax.clazz

/**
 * Created by Administrator on 2021/6/13.
 */
fun main() {

    //抽象类


    //匿名类
//    anonymousOne()

    //静态类
//    staticOne()

    //伴随对象
//    CompanionClass.one()

    //扩展函数
//    var oneTC: OneTC = OneTC()
//    oneTC.show()

    //继承父类的扩展函数
//    var sub: SubOneTC = SubOneTC()
//    sub.show()
//    println("sub.a = ${sub.a}")

    //扩展属性
//    var oneTC: OneTC = OneTC()
//    oneTC.a = 4
//    println("oneTC = ${oneTC.a}")

    //扩展函数作为成员函数
//    var three: ThreeTC = ThreeTC(TwoTC())
//    three.show()

    //继承
//    var twoInherit:TwoInherit = TwoInherit()
//    twoInherit.show()

    //内联类
//    val oneIC: OneIC = OneIC("abcdefg")
//    println("oneIC.s = ${oneIC.s}, oneIC.size = ${oneIC.size}")
//    show(oneIC)


    //内联类VS类型别名
//    val nameAlias: NameTypeAlias = ""
//    val nameInlineClass: NameInlineClass = NameInlineClass("")
//    val string: String = ""
//
//    acceptString(nameAlias) // OK: pass alias instead of underlying type
////    acceptString(nameInlineClass) // Not OK: can't pass inline class instead of underlying type
//
//    // And vice versa:
//    acceptNameTypeAlias(string) // OK: pass underlying type instead of alias
////    acceptNameInlineClass(string) // Not OK: can't pass underlying type instead of inline class
}

private fun staticOne() {

    //静态类属性
    println(S.k)

    //静态类实现接口
//    println(SI.k)
//    SI.show()


}

private fun anonymousOne() {
    val helloWorld = object {
        val hello = "Hello"
        val world = "World"

        // object expressions extend Any, so `override` is required on `toString()`
        override fun toString() = "$hello $world"
    }
    println("helloWorld = ${helloWorld}")
}


class CompanionClass {
    companion object A {
        fun one() {
            println("one")
        }
    }
}


open class OneTC {
    var i: Int = 0
        get() = field
        set(value: Int) {
            field = value
        }
}

fun OneTC.show() {
    println("i = ${this.i}")
}

var OneTC.a: Int
    get() = i
    set(value) {
        i = value
    }

class SubOneTC : OneTC() {}


class TwoTC {}

class ThreeTC(val two: TwoTC) {
    fun TwoTC.show() {
        println("~~TwoTC.show()~~")
        println("this = ${this}")
        println("this@ThreeTC = ${this@ThreeTC}")
    }

    fun show() {
        two.show()
    }
}

open class OneInherit {
    open var k: Int = 2
    open fun show() {
        println("~~OneInherit.show()~~")
    }
}

class TwoInherit : OneInherit() {
    override var k = 21
    override fun show() {
        println("~~TwoInherit.show()~~")
        println("k = ${k}")
    }
}


/**
 * 内联类
 */
//@JvmInline
//value class OneIC(val s: String) {
//    var size: Int
//    get() = s.length
//    set(v) {s.substring(v)}
//}

@JvmInline
value class OneIC(val s: String) {
    var size: Int
        get() = s.length
        set(v) {
            s.substring(v)
        }
}

@JvmName("oic")
public fun show(oIC: OneIC) {
    println("oIC.s = ${oIC.s}, oIC.size = ${oIC.size}")
}

//别名与内联类
typealias NameTypeAlias = String

@JvmInline
value class NameInlineClass(val s: String)

fun acceptString(s: String) {}
fun acceptNameTypeAlias(n: NameTypeAlias) {}
fun acceptNameInlineClass(p: NameInlineClass) {}


/**
 * 抽象类
 */
interface ThreeTCI {
    fun see()
}

abstract class ThreeTheClass() {
    abstract fun show()
    open val k: Int = 2
    open fun see() {
        println("~~syntax.OneTTC.see~~")
    }
}

class OneTTC : ThreeTheClass() {
    override val k: Int = 2
    override fun show() {
        println("~~syntax.OneTTC.show~~")
    }

    override fun see() {
        println("~~syntax.OneTTC.show~~")
    }
}


/**
 * 静态类
 */
interface AAI {
    fun show()
}

//声明静态类S
object S {
    val k = 1
}

//声明静态类SI，它实现了AAI接口
object SI : AAI {
    val k = 1
    override fun show() {
        println("~~show~~")
    }
}