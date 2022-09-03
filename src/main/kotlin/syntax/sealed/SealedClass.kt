package syntax.sealed

/**
 * Created by Administrator on 2021/6/13.
 */
sealed class SealedClass{
    abstract fun show()
    open val k:Int = 3
    open fun see(){
        println("~~SealedClass.see~~")
    }
}
class OneSC: SealedClass() {
    override fun show() {
    }

    override val k:Int = 33
    override fun see(){
        println("~~OneSC.see~~")
    }
}

sealed class TheSealedClass{
    abstract fun show()
}

class OneTSC: TheSealedClass() {
    override fun show() {
    }
}
class TwoTSC: TheSealedClass() {
    override fun show() {
    }
}
object STSC : TheSealedClass() {
    override fun show() {
    }
}



fun main() {

    //实例化
//    val oneSC:OneSC = OneSC()
//    println("oneSC.k is ${oneSC.k}")
//    oneSC.see()
//    oneSC.show()



    //使用when表达式
    val k = when(val tsc:TheSealedClass = OneTSC()){
        STSC -> println("STSC")
        is OneTSC -> println("OneSC")
        else -> println("OneSC")
//        is TwoTSC -> println("TwoTSC")
    }
    println("k = ${k}")

}
