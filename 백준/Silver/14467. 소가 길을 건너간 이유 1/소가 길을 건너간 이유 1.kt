import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val times = readLine().toInt()
    val currentLocation = IntArray(11) { -1 }
    var totalMovingTime = 0

    repeat(times) {
        val (cow, location) = readLine().split(" ").map { it.toInt() }
        if (currentLocation[cow] == -1) currentLocation[cow] = location
        else if (currentLocation[cow] != location) {
            totalMovingTime++
            currentLocation[cow] = location
        }
    }

    println(totalMovingTime)
}