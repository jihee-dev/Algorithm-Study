import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val (start, end, quit) = bufferedReader.readLine().split(" ")
    val beforeStart = mutableSetOf<String>()
    val attendee = mutableSetOf<String>()

    while (true) {
        val chatLog: String = bufferedReader.readLine() ?: break
        val (time, nickname) = chatLog.split(" ")
        when {
            time <= start -> beforeStart.add(nickname)
            time in end..quit -> if (beforeStart.contains(nickname)) attendee.add(nickname)
        }
    }
    println(attendee.size)
}