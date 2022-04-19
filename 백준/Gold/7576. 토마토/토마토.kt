import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (M, N) = readLine().split(" ").map { it.toInt() }
    val tomatoBox = Array(N + 2) { IntArray(M + 2) { -1 } }
    var day = -1
    var ripeTomatoes: Queue<Pair<Int, Int>> = LinkedList()

    for (i in 1..N) {
        val temp = readLine().split(" ").map { it.toInt() }.toMutableList()
        temp.add(0, -1)
        temp.add(M + 1, -1)
        tomatoBox[i] = temp.toIntArray()
    }

    tomatoBox.forEachIndexed { i, row ->
        row.forEachIndexed { j, tomato ->
            if (tomato == 1) {
                ripeTomatoes.add(Pair(i, j))
            }
        }
    }

    while (ripeTomatoes.isNotEmpty()) {
        day++
        val now: Queue<Pair<Int, Int>> = LinkedList()
        now.addAll(ripeTomatoes)
        ripeTomatoes = LinkedList()

        now.forEach { ijPair ->
            val i = ijPair.first
            val j = ijPair.second

            if (tomatoBox[i][j - 1] == 0) {
                tomatoBox[i][j - 1] = 1
                ripeTomatoes.add(Pair(i, j - 1))
            }

            if (tomatoBox[i][j + 1] == 0) {
                tomatoBox[i][j + 1] = 1
                ripeTomatoes.add(Pair(i, j + 1))
            }

            if (tomatoBox[i - 1][j] == 0) {
                tomatoBox[i - 1][j] = 1
                ripeTomatoes.add(Pair(i - 1, j))
            }

            if (tomatoBox[i + 1][j] == 0) {
                tomatoBox[i + 1][j] = 1
                ripeTomatoes.add(Pair(i + 1, j))
            }
        }
    }

    for (i in 1..M) {
        for (j in 1..N) {
            if (tomatoBox[j][i] == 0) {
                println(-1)
                return
            }
        }
    }

    println(day)
}