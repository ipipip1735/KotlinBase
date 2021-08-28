package syntax

import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Administrator on 2021/6/18.
 */
fun main() {
    /*---接口代理---*/
    //接口代理（重写接口）
//    val oneD: OneD = OneD(OneDII())
//    oneD.show()

    //代理对象使用扩展函数
//    val aa: AAResource by BBResource()
//    println("aa = ${aa}")

    //接口代理(使用匿名类作为代理对象)
//    println("readWrite = ${readWrite}")
//    readWrite = 9
//    println("readWrite = ${readWrite}")



    /*---属性代理---*/
    //属性代理
//    var mc:MyClass = MyClass(1, ClassWithDelegate(2))
//    println("mc.delegatedToMember = ${mc.delegatedToMember}")
//    println("mc.delegatedToTopLevel = ${mc.delegatedToTopLevel}")
//    println("mc.delegatedToAnotherClass = ${mc.delegatedToAnotherClass}")
//    println("MyClass.extDelegated = ${mc.extDelegated}, topLevelInt = ${topLevelInt}")

    //属性代理（重写provideDelegate运算符）
    val i: Int by ResouceLoader()
    println("i = ${i}")
//    var i: Int by ResouceLoader()
//    println("i = ${i}")
//    i = 33
//    println("i = ${i}")


    //属性代理（属性别名）
//    var r: Resource by ResourceDelegate()
//    println("r = ${r}")
//    r = Resource()
//    println("r = ${r}")

    //接口代理（懒加载）
//    println(lazyValue)
//    println(lazyValue)
//    println(Thread.currentThread())//指定线程
//    println(asyncLazyValue)

    //接口代理(观察者)
//    println("name = ${name}")
//    name = "s"
//    println("name = ${name}")

    //接口代理(拦截器)
//    age = 8
//    println("age = ${age}")

}

/**
 * 对象代理
 */
interface OneDI{
    val string:String
    fun show()
}

class OneDII : OneDI{
    override val string: String = "xx"
    override fun show() {
        println("string = ${string}")
    }
}

class OneD(odii:OneDII) : OneDI by odii{
    override val string: String = "TTTTTTTT"
    override fun show() {
        println("OneD|string = ${string}")
    }
}

class ZeroD(name:String) : OneDI by OneDII(){
    override val string: String = "TTTTTTTT"
    override fun show() {
        println("OneD|string = ${string}")
    }
}



/**
 * 懒加载
 */
val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

val asyncLazyValue: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
    println("computed!")
    println(Thread.currentThread())
    "Hello"
}

/**
 * 观察者
 */
var name: String by Delegates.observable("xx") { prop, old, new ->
    println("$prop|$old -> $new")
}

/**
 * 拦截器
 */
var age: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
    println("property = [${property}], oldValue = [${oldValue}], newValue = [${newValue}]")
    false
}


/**
 * 属性代理（属性别名）
 */
var topLevelInt: Int = 0

class ClassWithDelegate(val anotherClassInt: Int)
class MyClass(var memberInt: Int, val anotherClassInstance: ClassWithDelegate) {
    var delegatedToMember: Int by this::memberInt
    var delegatedToTopLevel: Int by ::topLevelInt

    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt
}

var MyClass.extDelegated: Int by ::topLevelInt


/**
 * 属性代理
 */
class Resource
class ResourceDelegate {
    operator fun getValue(nothing: Nothing?, property: KProperty<*>): Resource {
        println("nothing = [${nothing}], property = [${property}]")
        return Resource()
    }

    operator fun setValue(nothing: Nothing?, property: KProperty<*>, resource: Resource) {
        println("nothing = [${nothing}], property = [${property}], resource = [${resource}]")
    }
}

/*-----使用扩展函数重写运算符-------*/
class AAResource
class BBResource

operator fun BBResource.getValue(nothing: Nothing?, property: KProperty<*>): AAResource {
    println("nothing = [${nothing}], property = [${property}]")
    return AAResource()
}

/*------读写属性------*/
var readWrite: Int by object : ReadWriteProperty<Any?, Int> {
    var int: Int = 0;
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        println("thisRef = [${thisRef}], property = [${property}]")
        return int
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        println("thisRef = [${thisRef}], property = [${property}], value = [${value}]")
        int = value
    }
}


/*------重写操作符provideDelegate------*/
//provideDelegate操作符返回ReadWriteProperty
//class ResouceLoader{
//    operator fun provideDelegate(nothing: Nothing?, property: KProperty<*>): ReadWriteProperty<Nothing?, Int> {
//        println("~~ResouceLoader.provideDelegate~~")
//        println("nothing = [${nothing}], property = [${property}]")
//        return object : ReadWriteProperty<Nothing?, Int> {
//            var k = 22
//            override fun getValue(thisRef: Nothing?, property: KProperty<*>): Int {
//                println("~~ResouceLoader.getValue~~")
//                println("thisRef = [${thisRef}], property = [${property}]")
//                return k
//            }
//
//            override fun setValue(thisRef: Nothing?, property: KProperty<*>, value: Int) {
//                println("~~ResouceLoader.setValue~~")
//                println("thisRef = [${thisRef}], property = [${property}], value = [${value}]")
//                k = value
//            }
//        }
//
//    }
//}

//provideDelegate操作符返回ReadWriteProperty
class ResouceLoader{
    operator fun provideDelegate(nothing: Nothing?, property: KProperty<*>): ReadOnlyProperty<Nothing?, Int> {
        println("~~ResouceLoader.provideDelegate~~")
        println("nothing = [${nothing}], property = [${property}]")
        return object : ReadOnlyProperty<Nothing?, Int> {
            override fun getValue(thisRef: Nothing?, property: KProperty<*>): Int {
                println("~~ResouceLoader.getValue~~")
                println("thisRef = [${thisRef}], property = [${property}]")
                return 22
            }
        }

    }
}

//provideDelegate比ReadWriteProperty优先级高
//class ResouceLoader: ReadWriteProperty<Any?, Int>{
//    //provideDelegate()优先级更高
//    operator fun provideDelegate(nothing: Nothing?, property: KProperty<*>): ReadOnlyProperty<Nothing?, Int> {
//        println("~~ResouceLoader.provideDelegate~~")
//        println("nothing = [${nothing}], property = [${property}]")
//        //方式一：使用匿名类实现ReadOnlyProperty接口
////        return object : ReadOnlyProperty<Nothing?, Int> {
////            override fun getValue(nothing: Nothing?, property: KProperty<*>): Int {
////                println("~~ResouceLoader.getValue~~")
////                println("nothing = [${nothing}], property = [${property}]")
////                return 1
////            }
////        }
//        //方式二：使用Lambda表达式实现ReadOnlyProperty接口（函数式接口）
//        return ReadOnlyProperty<Nothing?, Int> { nothing, property ->
//            println("~~ResouceLoader.provideDelegate~~")
//            println("nothing = [${nothing}], property = [${property}]")
//            1111
//        }
//
//    }
//
//    //provideDelegate()注释后才会调用getValue()
//    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
//        println("~~ResouceLoader.getValue1~~")
//        println("thisRef = [${thisRef}], property = [${property}]")
//        return 2
//    }
//
//    //用于写操作
//    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
//        println("~~ResouceLoader.setValue~~")
//        println("thisRef = [${thisRef}], property = [${property}], value = [${value}]")
//    }
//}