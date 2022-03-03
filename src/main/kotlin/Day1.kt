private fun List<Int>.countIncreasing() = this.fold(Pair(0, Int.MAX_VALUE)) { (acc: Int, prev: Int), cur: Int ->
        if (cur > prev) Pair(acc + 1, cur) else Pair(acc, cur)
    }.first

fun day1(rows: List<String>) = rows.map(String::toInt).countIncreasing()

fun day1part2(rows: List<String>) = rows.map(String::toInt).let {
        it.subList(0, it.size - 2).mapIndexed { i, cur ->
            cur + it[i + 1] + it[i + 2]
        }
    }.countIncreasing()

fun main() {
    val res = day1part2(readPuzzle("day1.txt"))
    println(res)
}