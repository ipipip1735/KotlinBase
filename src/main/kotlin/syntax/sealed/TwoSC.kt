package syntax.sealed

/**
 * Created by Administrator on 2021/7/26.
 */
class TwoSC : SealedClass() {
    override fun show() {
    }

    override val k: Int = 33
    override fun see() {
        println("~~TwoSC.see~~")
    }
}

class Three {
    class ThreeSC : SealedClass() {
        override fun show() {
        }
    }
}

interface A {
    fun show()
}

class Four {
    //内嵌类（即类中的静态类）继承密封类
    object SSC : SealedClass() {
        override fun show() {
            println("~~SSC show~~")
        }
    }

    companion object : SealedClass() {
        override fun show() {
            println("~~companion object show~~")
        }
    }
}


fun main() {
    //实例化
//    val twoSC = TwoSC()
//    println("twoSC.see() = ${twoSC.see()}")

    Four.SSC.show();
    Four.show()


}