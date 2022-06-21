import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var paper: Array<BooleanArray>
var whitePaperCount = 0
var bluePaperCount = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    paper = Array(n) { BooleanArray(n) }

    repeat(n) { index ->
        paper[index] = readLine().split(" ").map { it == "1" }.toBooleanArray()
    }

    dfs(0, 0, n)
    print("$whitePaperCount\n$bluePaperCount")
}

private fun dfs(startRowIdx: Int, startColumnIdx: Int, size: Int) {
    var isAllBlue = true
    var isAllWhite = true
    for (i in startRowIdx until startRowIdx + size) {
        for (j in startColumnIdx until startColumnIdx + size) {
            if (paper[i][j]) isAllWhite = false
            else isAllBlue = false
        }
    }

    if (isAllWhite) {
        whitePaperCount++
        return
    }

    if (isAllBlue) {
        bluePaperCount++
        return
    }

    val nextSize = size / 2
    dfs(startRowIdx, startColumnIdx, nextSize)
    dfs(startRowIdx, startColumnIdx + nextSize, nextSize)
    dfs(startRowIdx + nextSize, startColumnIdx, nextSize)
    dfs(startRowIdx + nextSize, startColumnIdx + nextSize, nextSize)
}