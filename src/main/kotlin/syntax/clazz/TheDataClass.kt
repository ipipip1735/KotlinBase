package syntax.clazz

/**
 * Created by Administrator on 2021/6/13.
 */
data class TheDataClass(var name:String, var id:Int)

data class OneDataClass(val name:String){
    init {
        val k:Int = 1
    }
}
data class TwoDataClass(val map:Map<String, Any?>){
    //只有主构造函数中的map参与toString()、equals()、hashCode()、copy()，下面的代理属性不能享受数据对象代理的便利
    val name:String by map
    val id: Int by map
    val age:Int by map
}

/**
 * 数据类继承普通类
 */
open class OneDC(var name:String, id: Int)
data class SubODC(var sname:String, var id: Int):OneDC("[base]"+sname, id)

fun main() {
    //自动生成toString()
//    val tdc:TheDataClass = TheDataClass("zero", 0)
//    println("tdc = ${tdc}")

    //如果所有属性都相等，那么hashCode也相等
//    val tdc1 = TheDataClass("one", 1)
//    val tdc2 = TheDataClass("one", 2)
//    println("tdc1 == tdc2 is ${tdc1 == tdc2}")//判断是否为等值（即判断是否所有属性都相等）
//    println("tdc1 === tdc2 is ${tdc1 === tdc2}")
//    println("tdc1.hashCode() = ${tdc1.hashCode()}, tdc2.hashCode() = ${tdc2.hashCode()}")//打印hashCode

    //自动生成copy()方法
//    val tdc3 = tdc1.copy("three")
//    println("tdc3 = ${tdc3}")

    //自动生成component1~n()方法
//    println("tdc3.name = ${tdc3.component1()}, tdc3.id = ${tdc3.component2()}")// 10

    //分解数据类
//    val (a, b) = TheDataClass("zero", 0)
//    println("a = ${a}, b = ${b}")


    //使用
//    val one = OneDataClass("Bob")
//    val two = one.copy("Jack")
//    println("one = ${one}, two = ${two}")


    //数据类继承普通类
//    val sub :SubODC = SubODC("one", 11)
//    println("sub = ${sub}, sub.name = ${sub.name}")
//
//    val sub1 = sub.copy("jack", 22)
//    sub1.name = "ooo"
//    sub1.sname = "one"
//    sub1.id = 11
//    println("sub.equals(sub1) is ${sub.equals(sub1)}")


    //标准库内置数据类
//    val p : Pair<String, Int> = Pair("one", 111)
//    println("p = ${p}")
//    println("p.toList() = ${p.toList()}")
//    val k = p to 11
//    println("k = ${k}")
//    val t:Triple<String, Int, Float> = Triple("one", 22, 3.33f)
//    println("t = ${t}")
//    println("t = ${t.toList()}")


    //数据对象使用属性代理
    val (n, a) = TheDataClass("Bob", 12)

    val two:TwoDataClass = TwoDataClass(mapOf("name" to "Bob", "age" to 11, "id" to 999))
    println("two = ${two}")
    val (m) = two





}