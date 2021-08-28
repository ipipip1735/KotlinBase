package syntax

/**
 * Created by Administrator on 2021/7/8.
 */
fun main() {
    var li: List<String> = listOf()


    for (i in 1 until  100){

    }

//    demo(l)
}
fun demo(source: List<Int>) {
    val list = ArrayList<Int>()
    for (item in source) {
        list.add(item)
    }

    for (i in 0..source.size - 1) {
        list[i] = source[i] // get and set are called
    }
}

