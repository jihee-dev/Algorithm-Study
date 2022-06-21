import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

var num = 0
var row = 0
var column = 0
var answer = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, r, c) = readLine().split(" ").map { it.toInt() }
    val size = (2.0).pow(n).toInt()
    row = r
    column = c

    dfs(0, 0, size)
    print(answer)
}

private fun dfs(startRowIdx: Int, startColumnIdx: Int, size: Int) {
    if (startRowIdx == row && startColumnIdx == column) {
        answer = num
        return
    }

    if (startRowIdx <= row && row < startRowIdx + size && startColumnIdx <= column && column < startColumnIdx + size) {
        val nextSize = size / 2
        dfs(startRowIdx, startColumnIdx, nextSize)
        dfs(startRowIdx, startColumnIdx + nextSize, nextSize)
        dfs(startRowIdx + nextSize, startColumnIdx, nextSize)
        dfs(startRowIdx + nextSize, startColumnIdx + nextSize, nextSize)
    } else {
        num += size * size
    }
}