package syntax.clazz

/**
 * Created by Administrator on 2021/8/5.
 */
object StaticClass{
    val i:Int = 1
    fun show(){
        println("~~show~~")
    }
}

fun main() {
    val sc = StaticClass
    println("sc.i is ${sc.i}")
    sc.show()

    getSc(StaticClass)
}


fun getSc(sc:StaticClass):StaticClass{
    println("sc = [${sc}]")
    return sc
}