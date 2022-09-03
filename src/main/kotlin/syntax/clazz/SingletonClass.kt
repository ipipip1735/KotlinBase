package syntax.clazz

/**
 * Created by Administrator on 2021/8/5.
 */
object SingletonClass{
    val i:Int = 1
    fun show(){
        println("~~show~~")
    }
}

fun main() {
    val sc = SingletonClass
    println("sc.i is ${sc.i}")
    sc.show()

    getSc(SingletonClass)
}


fun getSc(sc:SingletonClass):SingletonClass{
    println("sc = [${sc}]")
    return sc
}