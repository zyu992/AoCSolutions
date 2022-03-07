data class Index(val k: Int, val i: Int, val j: Int)

fun day4(rows: List<String>): Int {
    val numbers = rows[0].split(',').map(String::toInt)
    val boards = mutableListOf<MutableList<List<Int>>>()

    for (row in rows) {
        if (row.isBlank()) {
            boards.add(mutableListOf())
        } else {
            boards.lastOrNull()?.add(row.split(' ').filterNot(String::isBlank).map(String::toInt))
        }
    }

    val vis = boards.map { board -> board.map { row -> row.map { false }.toMutableList() } }

    val dict = boards.flatMapIndexed { k, board ->
        board.flatMapIndexed { i, row ->
            row.mapIndexed { j, n ->
                n to (Index(k, i, j))
            }
        }
    }.groupBy({ p -> p.first }, { p -> p.second })

    for (n in numbers) {
        for ((k, i, j) in dict[n] ?: emptyList()) {
            vis[k][i][j] = true
            if (vis[k][i].all { it } || vis[k].map { it[j] }.all { it }) {
                val res = boards[k].foldIndexed(0) { x, acc1, row ->
                    row.foldIndexed(acc1) { y, acc2, m ->
                        if (!vis[k][x][y]) acc2 + m else acc2
                    }
                } * n
                return res
            }
        }
    }
    return -1
}

fun main() {
    val puzzle = readPuzzle("day4.txt")
    print(day4(puzzle))
}

