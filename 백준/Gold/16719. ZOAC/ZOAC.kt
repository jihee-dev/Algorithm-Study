import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var isOpen: BooleanArray
private lateinit var str: String

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    str = readLine()
    isOpen = BooleanArray(str.length)
    findNextChar(0, str.length - 1)
}

fun findNextChar(startIdx: Int, lastIdx: Int) {
    var minChar = Char.MAX_VALUE
    var minIdx = -1
    val stringBuffer = StringBuffer()

    for (index in startIdx..lastIdx) {
        if (str[index] < minChar) {
            minChar = str[index]
            minIdx = index
        }
    }

    if (minChar == Char.MAX_VALUE) return
    isOpen[minIdx] = true

    isOpen.forEachIndexed { index, open ->
        if (open) stringBuffer.append(str[index])
    }
    println(stringBuffer.toString())

    findNextChar(minIdx + 1, lastIdx)
    findNextChar(startIdx, minIdx - 1)
}