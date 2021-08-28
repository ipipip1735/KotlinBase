package syntax

/**
 * Created by Administrator on 2021/6/13.
 */
class ListTrail {
}

//fun main() {
//    //filter
////    val numbers = listOf(1, -2, 3, -4, 5, -6)
////    val positives = numbers.filter { x -> x > 0 }
////    println("positives = ${positives}")
////    val negatives = numbers.filter { it < 0 }
////    println("negatives = ${negatives}")
//
//
//
//
//    //none
////    val numbers = listOf(1, -2, 3, -4, 5, -6)
////    val allEven = numbers.none { it % 2 == 1 }
////    println("allEven = ${allEven}")
////    val allLess6 = numbers.none { it > 6 }
////    println("a = ${allLess6}")
//
//
//
//
////    val words = listOf("Lets", "find", "something", "in", "collection", "somehow")
////
////    val first = words.find { it.startsWith("some") }
////    val last = words.findLast { it.startsWith("so8me") }
////    val nothing = words.find { it.contains("nothing") }
////    println("first = ${first}, last = ${last}, nothing = ${nothing}")
//
//
//
//
//
//    val words = listOf("foo", "bar", "baz", "faz")
//    val empty = emptyList<String>()
//    val first = empty.firstOrNull()
//    val last = empty.lastOrNull()
//    println("first = ${first}, last = ${last}")
//
//    val firstF = words.firstOrNull { it.startsWith('f') }
//    val firstZ = words.firstOrNull { it.startsWith('z') }
//    val lastF = words.lastOrNull { it.endsWith('f') }
//    val lastZ = words.lastOrNull { it.endsWith('z') }
//
//}


data class Person(val name: String, val city: String, val phone: String)
fun main() {
    val people = listOf(
        Person("John", "Boston", "+1-888-123456"),
        Person("Sarah", "Munich", "+49-777-789123"),
        Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
        Person("Vasilisa", "Saint-Petersburg", "+7-999-123456"))

    val phoneBook = people.associateBy { it.phone }
    println("phoneBook = ${phoneBook}")

    val cityBook = people.associateBy(Person::phone, Person::city)
    println("cityBook = ${cityBook}")

}