package syntax

/**
 * Created by Administrator on 2021/6/16.
 */
fun main() {

    //重写+号运算符
//    val a = AOP()
//    val b= AOP()
//    val c = a + b
//    println("a = $a, b = $b, c = $c")


    //重写invoke运算符
    val b = BOP()
    b(6)


}

class AOP {
    operator fun plus(b: AOP): AOP {
        println("~~plus~~")
        println("this is $this, b = [${b}]")
        return AOP()
    }
}

class BOP {

    operator fun invoke(i:Int) {
        println("~~invoke~~")
        println("i = [${i}]")
    }
}