package syntax.clazz

/**
 * Created by Administrator on 2021/6/18.
 */
fun main() {
    val i: Int = OuterA.Nested().foo()
    println("i = ${i}")

    val j: OuterB.Inner = OuterB().Inner()
    println(j.foo())

    val h: BInner = OuterB().Inner()
    println(h.foo())
}

class OuterA {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
    }
}

typealias BInner = OuterB.Inner
class OuterB {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = 2
    }
}





