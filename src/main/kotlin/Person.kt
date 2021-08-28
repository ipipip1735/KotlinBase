/**
 * Created by Administrator on 2021/7/28.
 */
class Person(var firstName: String) {
    @JvmField
    var id: Int = 1;

    lateinit var gf: String

    companion object {
        @JvmField
        val borthday: Long = 20210728

        lateinit var bf: String
    }
}