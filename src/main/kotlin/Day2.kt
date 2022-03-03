data class Coordinate(val x: Int, val y: Int)

fun day2(rows: List<String>) = rows
    .map { commands -> commands.split(' ') }
    .fold(Coordinate(0, 0)) { (x: Int, y: Int), (dir: String, units: String) ->
        when (dir) {
            "forward" -> Coordinate(x + units.toInt(), y)
            "up" -> Coordinate(x, y - units.toInt())
            "down" -> Coordinate(x, y + units.toInt())
            else -> throw java.lang.IllegalArgumentException()
        }
    }

fun main() {
    val (x, y) = day2(readPuzzle("day2.txt"))
    println(x * y)
}
