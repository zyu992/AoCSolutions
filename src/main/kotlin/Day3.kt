import kotlin.math.abs

fun day3(rows: List<String>) = rows
    .first()
    .mapIndexed { i, _ -> rows.map { it.getOrNull(i) } } // transpose the input
    .map { it.count { ch -> ch == '1' } }
    .map { ones -> if (ones > rows.size / 2) 1 else 0 }
    .let {
        val gamma = it.fold(0) { acc, cur -> (acc shl 1) + cur }
        val epsilon = it.fold(0) { acc, cur -> (acc shl 1) + abs(cur-1) }
        gamma * epsilon
    }

fun main() {
    val res = day3(readPuzzle("day3.txt"))
    println(res)
}