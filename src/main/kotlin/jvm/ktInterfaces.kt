package jvm

/**
 * Created by Administrator on 2021/7/28.
 */
interface ktInterfaces {

    fun see(){
        System.out.println("~~interfaces.see~~");
    }

    fun show()
}

//fun main() {
//    val kti = object :ktInterfaces{
//        override fun show() {
//            println("~~show~~")
//        }
//    }
//    kti.see()
//    kti.show()
//
//
//}