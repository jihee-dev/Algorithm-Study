import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var mines: Array<CharArray>
private lateinit var answer: Array<CharArray>
private var n = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    mines = Array(n) { CharArray(n) { '.' } }
    val opens = Array(n) { BooleanArray(n) { false } }
    answer = Array(n) { CharArray(n) { '.' } }
    var isAllMinesAreMarked = false


    repeat(n) { index -> mines[index] = readLine().map { it }.toCharArray() }
    repeat(n) { index -> opens[index] = readLine().map { it == 'x' }.toBooleanArray() }

    repeat(n) { i ->
        repeat(n) { j ->
            if (opens[i][j]) {
                when(mines[i][j]) {
                    '.' -> answer[i][j] = Character.forDigit(findMineCount(i, j), 10)
                    '*' -> {
                        if (!isAllMinesAreMarked) {
                            markAllMines()
                            isAllMinesAreMarked = true
                        }
                    }
                }
            }
        }
    }

    val stringBuffer = StringBuffer()
    repeat(n) { i ->
        repeat(n) { j ->
            stringBuffer.append(answer[i][j])
        }
        stringBuffer.append("\n")
    }
    print(stringBuffer.toString())
}

private fun findMineCount(x: Int, y: Int): Int {
    val dx = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
    val dy = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
    var count = 0

    for (i in 0..7) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]

        if( nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue
        if (mines[nextX][nextY] == '*') count++
    }

    return count
}

private fun markAllMines() {
    repeat(n) { i ->
        repeat(n) { j ->
            if (mines[i][j] == '*') answer[i][j] = '*'
        }
    }
}