package syntax.collection

/**
 * Created by Administrator on 2021/6/13.
 */
fun main() {

    val map = mapOf<String, Int>("one" to 11, "two" to 22)

    //使用索引访问元素
//    println(map["three"])


    //遍历
//    map.forEach{
//        println("key is ${it.key}, value is ${it.value}")
//    }


//    for (key in map.keys) {
//        println("map[$key] = ${map[key]}")
//    }

//    for (value in map.values) {
//        println("value = $value")
//    }

    map.mapValues {
        println("it = ${it}")
    }

}