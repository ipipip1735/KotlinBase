package syntax

/**
 * Created by Administrator on 2021/6/24.
 */
fun main() {
    var init: DSL.()->Unit = { println("this = ${this}") }
    init(DSL())
    DSL().init()

//    var start: (DSL) -> Unit = { dsl -> println("dsl = $dsl")}
    var start: (DSL) -> Unit = { println("dsl = $it")}
    start(DSL())

    start = init
    start(DSL())


}


class DSL