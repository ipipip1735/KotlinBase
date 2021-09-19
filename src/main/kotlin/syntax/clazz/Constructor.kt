package syntax

/**
 * Created by Administrator on 2021/6/16.
 */
const val FLAG = "XX"
fun main() {

//    val oc = OneConstructor("one", 1, 11)
//    println("oc = ${oc}")


    var aa: AA = AA(2)
    println("aa = ${aa}")
//
//    var bb: AA = AA("one", 2)
//    println("bb = ${bb}")


//    var bb:BB = BB(22, "BBBBBB")
//    println("bb.int = ${bb.int}")
//    println("bb.string = ${bb.string}, bb.string1 = ${bb.string1}")

//    val cc:CC= CC()
//    println("cc.int = ${cc.int}")
//    cc.int = 88
//    println("cc.int = ${cc.int}")


//    val cc: CC = CC()
//    println(cc.int)
//    cc.int = 99


//    val dd: DD = DD()
//    println("dd.i = ${dd.i}")
//    dd.i = 99
//    println("dd.i = ${dd.i}")


//    var ff:FF = FF()
//    ff.d()
}

class OneConstructor(val age: Int, ) {

    init {
        println("~~init1~~")
        println("age = ${age}")
    }

    init {
        println("~~init2~~")
        println("age = ${age}")
    }

    constructor(n: Int, id: Long) : this(n) {
        println("~~constructor1~")
        println("n = [${n}], id = [${id}]")
    }

    constructor(name: String, n: Int, id: Long) : this(n, id) {
        println("~~constructor2~")
        println("name = [${name}], n = [${n}], id = [${id}]")
    }
}

class AA constructor(int: Int) {

    init {
        println("~~AA.init~~")
        println("int = ${int}")
    }

    constructor(string: String, int: Int) : this(int) {
        println("two|AA.constructor")
        println("string = [${string}], int = [${int}]")
    }

}

class BB(int: Int, val string1: String) {
    var int = int
    var string = "AAA"
}

class CC() {
    var int: Int = 8
        get():Int {
            println("~~getter~~")
            return field
        }
        set(value) {
            println("~~setter~~")
            println("value = ${value}")
            field = value
        }
}

class DD() {
    private var _i: Int = 1
    var i: Int
        get() = _i
        set(value) {
            _i = value
        }
}

class EE() {
    companion object {
        const val INT = 1
        fun aa() = INT
    }

    var ff: FF = FF()
    fun check() {

    }
}

class FF() {
    lateinit var ss: String
    fun d() {
        println("isInitialized is " + this::ss.isInitialized)
    }
}