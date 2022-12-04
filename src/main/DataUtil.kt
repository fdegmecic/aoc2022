import java.io.File

fun readInputs(fileName: String) : List<String> =
    File("src/resource/inputs", "$fileName.txt").readLines()

fun readInputsAsString(fileName: String): String =
    File("src/resource/inputs", "$fileName.txt").readText()

