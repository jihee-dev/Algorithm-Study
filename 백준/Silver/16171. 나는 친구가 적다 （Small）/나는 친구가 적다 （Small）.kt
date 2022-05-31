import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val textbook = readLine()
    val keyword = readLine()

    val textbookDeletedAllNums = textbook.replace("[0-9]".toRegex(), "")
    println(if (textbookDeletedAllNums.contains(keyword)) 1 else 0)
}