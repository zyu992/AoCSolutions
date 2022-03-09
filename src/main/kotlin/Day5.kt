import kotlin.math.abs

data class Point(val x: Int, val y: Int)

fun day5(rows: List<String>) = rows
    .asSequence()
    .map { row ->
        "(\\d+),(\\d+)\\s->\\s(\\d+),(\\d+)"
            .toRegex()
            .matchEntire(row)
            ?.groupValues
            ?.drop(1)
            ?.map(String::toInt)
            ?: emptyList()
    }
    .map { (a, b, c, d) -> Pair(Point(a, b), Point(c, d)) }
    .fold(emptySequence<Point>()) { acc, (p1, p2) ->
        val (x1, y1) = p1
        val (x2, y2) = p2
        when {
            x1 == x2 -> acc + (minOf(y1, y2)..maxOf(y1, y2)).map { Point(x1, it) }
            y1 == y2 -> acc + (minOf(x1, x2)..maxOf(x1, x2)).map { Point(it, y1) }
            x1 - x2 == y1 - y2 -> acc + (0..abs(x1 - x2)).map { Point(minOf(x1, x2) + it, minOf(y1, y2) + it) }
            x1 - x2 == y2 - y1 -> acc + (0..abs(x1 - x2)).map { Point(minOf(x1, x2) + it, maxOf(y1, y2) - it) }
            else -> acc
        }
    }
    .groupBy { it }
    .count { it.value.size >= 2 }

fun main() {
    val res = day5(readPuzzle("Day5.txt"))
    print(res)
}