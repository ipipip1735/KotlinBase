package syntax

/**
 * Created by Administrator on 2021/6/13.
 */
fun main() {
    val one = OneSF()
    one.show()

    one.apply {
        println("this = ${this}")
    }
    one.run {
        println("this = ${this}")
    }

    one.let {
        println("it = ${it}")
    }

    one.also {
        println("it = ${it}")
    }

    one.takeIf {
        println("it = ${it}")
        true
    }

    one.takeUnless {
        println("it = ${it}")
        true
    }


}

class OneSF(var name: String = "Bob") {
    fun show() = apply {
        println("this = ${this}")
    }
}