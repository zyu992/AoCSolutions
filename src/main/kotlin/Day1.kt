fun day1(rows: List<String>) = rows
    .fold(Pair(0, Int.MAX_VALUE)) { (acc: Int, prev: Int), s: String ->
        when {
            s.toInt() > prev -> Pair(acc + 1, s.toInt())
            else -> Pair(acc, s.toInt())
        }
    }.first

fun main() {
    val res = day1(readPuzzle("day1.txt"))
    println(res)
}