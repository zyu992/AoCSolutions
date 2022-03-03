class Main

fun readPuzzle(file: String) = Main::class.java
    .getResource(file)
    ?.readText()
    ?.split('\n')
    ?: emptyList()
