import java.io.BufferedReader
import java.io.InputStreamReader

var row = 0
var column = 0
val dx = intArrayOf(-1, -1, 0)
val dy = intArrayOf(-1, 0, -1)
var count = 0
lateinit var nemmoGraph: Array<BooleanArray>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    row = N
    column = M

    nemmoGraph = Array(row) { BooleanArray(column) }

    backTracking(0)
    println(count)
}

fun backTracking(idx: Int) {
    if (idx == row * column) {
        count++
        return
    }

    val currentRow = idx / column
    val currentColumn = idx % column

    nemmoGraph[currentRow][currentColumn] = true
    if (canInsertBlock(currentRow, currentColumn)) {
        backTracking(idx + 1)
    }

    nemmoGraph[currentRow][currentColumn] = false
    backTracking(idx + 1)
}

fun canInsertBlock(x: Int, y: Int): Boolean {
    for (i in 0..2) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]

        if( nextX !in (0 until row) || nextY !in (0 until column)) return true
        if (!nemmoGraph[nextX][nextY]) return true
    }
    return false
}