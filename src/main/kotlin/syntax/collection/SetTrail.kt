package syntax.collection

/**
 * Created by Administrator on 2021/9/19.
 */
fun main() {
//    unmutable()//不变容器
//    mutable()//可变容器
    unorder()//无序Set集
}

fun unorder() {

    //使用构造函数
//    val set = HashSet<Int>(15)
//    println(set)
//    set.add(5)
//    println(set)
//    set.add(15)
//    println(set)
//    set.add(25)
//    println(set)
//    set.add(35)
//    println(set)

    //使用工厂方法
//    val set = hashSetOf<Int>(5, 8, 2, 99)
//    set.add(25)
//    println(set)
//    set.add(35)
//    println(set)

    //遍历增加时，是有序的
    val set = hashSetOf<Int>()
    for (i in 1..100) {
        set.add(i)
        println(set)
    }


}


fun mutable() {
    val set = mutableSetOf<Int>(1, 2, 3, 5, 8)
    set.add(15)
    set.forEach {
        print("$it, ")
    }
    println("")
    set.remove(15)
    set.forEach {
        print("$it, ")
    }
    println("")
    set.remove(80)
    set.forEach {
        print("$it, ")
    }

}


fun unmutable() {
    val set = setOf<Int>(1, 2, 3, 5, 8)

    set.forEach {
        print("$it, ")
    }

    println("")

    set.reversed()
        .forEach {
            print("$it, ")
        }

    println("")

    set.plus(22)
        .forEach {
            print("$it, ")
        }

    println("")

    set.minus(22)
        .forEach {
            print("$it, ")
        }

    println("")

    set.minus(80)
        .forEach {
            print("$it, ")
        }
}
