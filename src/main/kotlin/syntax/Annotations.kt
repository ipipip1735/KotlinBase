package syntax

import PJImpl
import java.lang.Error
import kotlin.jvm.Throws

/**
 * Created by Administrator on 2021/8/27.
 */
//使用@Throws
//fun main() {
//
//    val pureList:PureList<String> = PureList()
//    pureList.show()
//
//}
//class Throws{
//
//    @Throws(Error::class)
//    public fun show(){
//        println("~~ThrowsKt.show~~")
//    }
//}

//使用@PurelyImplements
//fun main() {
//    PJImpl<Int?>().show(null)
//
//}
//interface OneIF<T>{
//    fun show(t:T)
//}

//使用@Transient
fun main() {
    PJImpl<Int?>().show(null)

}
//class Rectangle : Serializable {
//    var length: Int = 0
//    var width: Int = 0
//    @Transient var area: Int? = null
//    //calculate rectangle area
//    fun calcArea() {
//        area = length * width
//    }
//}