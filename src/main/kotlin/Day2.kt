data class Coordinate(val x: Int, val y: Int)
data class CoordinateWithAim(val x: Int, val y: Int, val aim: Int)

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

fun day2part2(rows: List<String>) = rows
    .map { commands -> commands.split(' ') }
    .fold(CoordinateWithAim(0, 0, 0)) { (x: Int, y: Int, aim: Int), (dir: String, units: String) ->
        when (dir) {
            "forward" -> CoordinateWithAim(x + units.toInt(), y + aim * units.toInt(), aim)
            "up" -> CoordinateWithAim(x, y, aim - units.toInt())
            "down" -> CoordinateWithAim(x, y, aim + units.toInt())
            else -> throw java.lang.IllegalArgumentException()
        }
    }

fun main() {
    val (x, y) = day2(readPuzzle("day2.txt"))
    println(x * y)
}
