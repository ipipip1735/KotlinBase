package syntax

import kotlin.reflect.KFunction
import kotlin.reflect.KProperty

/**
 * Created by Administrator on 2021/6/23.
 */
fun main() {
//    reflect()
    reference()
}

fun reference() {


    val p:KProperty<Int> = String::length //获取反射对象
    println("p is KProperty<Int> = ${p is KProperty<Int>}, p.isConst = ${p.isConst}")

    val gl: (String) -> Int = String::length //引用成员属性的Getter
    val length = gl("xxxx")
    println("length = ${length}")


    //引用构造函数
//    val fc: () -> OneR = ::OneR
//    println("fc = ${fc}")
//    println("(::OneR is KFunction<OneR>) is ${::OneR is KFunction<OneR>}")
////    println("(fc is KFunction<OneR>) is ${fc is KFunction<OneR>}")
//    println("(fc is KFunction<*>) is ${fc is KFunction<*>}")

    //引用成员函数
//    val oneR: OneR = OneR()
//    println("oneR::fn is KFunction<Unit> = ${oneR::fn is KFunction<Unit>}")
}

fun reflect() {
    //类类型
//    val kClass = OneR::class
//    println("kClass is KClass is ${kClass is KClass<OneR>}")

    //函数类型
    val kFunction = ::fn
    println("(kFunction is KFunction<Unit>) = ${kFunction is KFunction<Unit>}")


    //属性类型
//    val kProperty = ::p
//    println("(kProperty is KProperty) is " + (kProperty is KProperty<Int>))
//    val kMutableProperty: KMutableProperty<Int> = ::v
//    println("(kMutableProperty is kMutableProperty) is " + (kMutableProperty is KMutableProperty<Int>))


    //获取Java反射对象
//    val field: Field? = OneR::int.javaField
//    println("field = ${field}")
//    println("field?.name = ${field?.name}")
//
//    val method: Method? = OneR::int.javaGetter
//    println("method = ${method}")
//    println("method?.name = ${method?.name}")
//
//    val clazz: Class<OneR> = OneR().javaClass
//    println("clazz = ${clazz}")
//
//    println("clazz.kotlin.equals(OneR::class) is " + clazz.kotlin.equals(OneR::class))


}


val p: Int = 8
var v: Int = 10

class OneR {
    val int: Int = 22
    fun fn(){
        println("~~OneR.fn~~")
    }
}

fun fn() {
    println("FLAG = ${FLAG}")
}