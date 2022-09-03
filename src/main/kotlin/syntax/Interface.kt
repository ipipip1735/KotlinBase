package syntax

/**
 * Created by Administrator on 2021/6/17.
 */
fun main() {
    //实现接口
//    var aa: AAIF = AAIF("SSS")
//    println("aa = ${aa}")


    //使用匿名类
//    var two:TwoI = object : TwoI{
//        override fun sum() {
//            TODO("Not yet implemented")
//        }
//    }

    //使用Lambda表达式
//    var two:TwoI = TwoI{99}

    //使用默认函数
//    var threeI: ThreeI = object : ThreeI{
//        override fun sum(): Int {
//            println("~~sum()~~")
//            return 1;
//        }
//    }
//    threeI.add()
//    threeI.sum()

    //使用默认函数
    val four:FourI = object: FourI{
        override val onReceive: FiveI = object : FiveI {
            override fun sum(k: () -> Unit) {
                TODO("Not yet implemented")
            }
        }

    }

    four.onReceive.sum{}
}

interface OneI {
    var ss: String
}

class AAIF(override var ss: String) : OneI {

}

fun interface TwoI {
    fun sum():Int
}

interface ThreeI {
    fun sum():Int
    fun add(){
        println("~~add()~~")
    }
}

interface FourI {
    public abstract val onReceive:FiveI
}
fun interface FiveI {
    fun sum(k:()->Unit):Unit
}