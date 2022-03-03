class Main

/*
    this function reads the file with the given file name
    under the resources directory and output its lines as
    a list of String
 */
fun readPuzzle(file: String) = Main::class.java
    .getResource(file)
    ?.readText()
    ?.split('\n')
    ?: emptyList()
