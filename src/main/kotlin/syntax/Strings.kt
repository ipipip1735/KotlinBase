package syntax

/**
 * Created by Administrator on 2021/7/28.
 */
fun main() {

    //方法别名
//    val countDown = buildString {
//        for (i in 5 downTo 1) {
//            append(i)
//            appendLine()
//        }
//    }
//    println(countDown)


    //判断为空
//    val s = "sds"
//    s.isBlank()


    //替换字符串
//    val input = "##place##holder##"
//    val result = input.removeSurrounding("##")
//    println(result)


    //替换字符串
    val result = """
        Kotlin
        Java 
    """.trimIndent()
    println(result)

}