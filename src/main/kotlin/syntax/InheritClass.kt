package syntax

/**
 * Created by Administrator on 2021/6/13.
 */
open class FourInC(){
    init {
        println("~~FourInC.init~~")
    }
}
class FiveInC : FourInC() {
    init {
        println("~~FiveInC.init~~")
    }
}
open class OneInC(open val id: Int)
class TwoInC(override val id: Int) : OneInC(id + 1) {
    override fun toString(): String {
        println("super.id =  ${super.id}")
        println("super<OneInC>.id =  ${super<OneInC>.id}")//多继承时使用super<XX>指定父类
        return "TwoInC(id=$id), super.id = ${super.id}"
    }
}

class ThreeInC(override val id: Int) : OneInC(id + 1) {
    override fun toString(): String {
        return "TwoInC(id=$id), super.id = ${super.id}"
    }

    fun show(){
        println("~~show~~")
    }

    inner class ATIC(){
        fun show(){
            val j = id
            val k = super@ThreeInC.id
            println("j = ${j}, k = ${k}")
        }
    }

}


fun main() {
    //继承
//    val one: OneInC = OneInC(1)
//    println("one = ${one}")
//    val two: TwoInC = TwoInC(1)
//    println("two = ${two}")

    //继承初始化代码块执行顺序
//    val five: FiveInC = FiveInC()

    //继承时使用内部类
    val tic:ThreeInC = ThreeInC(12)
    tic.ATIC().show()

}