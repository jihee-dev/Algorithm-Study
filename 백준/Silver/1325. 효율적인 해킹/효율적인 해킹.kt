import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

lateinit var graph: Array<ArrayList<Int>>
lateinit var isVisited: BooleanArray
lateinit var linkedComCount: IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (comCount, connectionCount) = readLine().split(" ").map { it.toInt() }
    graph = Array(comCount + 1) { ArrayList() }
    isVisited = BooleanArray(comCount + 1)
    linkedComCount = IntArray(comCount + 1)

    for (i in 0 until connectionCount) {
        val (comA, comB) = readLine().split(" ").map { it.toInt() }
        graph[comA].add(comB)
    }

    for (i in 1..comCount) {
        isVisited = BooleanArray(comCount + 1)
        bfs(i)
    }

    var maxCount = 0
    for (i in 1..comCount) maxCount = max(maxCount, linkedComCount[i])
    val sb = StringBuffer()
    for (i in 1..comCount) if (linkedComCount[i] == maxCount) sb.append("$i ")
    print(sb.toString())
}

fun dfs(idx: Int) {
    isVisited[idx] = true
    for (i in 0 until graph[idx].size) {
        val next = graph[idx][i]
        if (!isVisited[next]) {
            linkedComCount[next]++
            dfs(next)
        }
    }
}

fun bfs(idx: Int) {
    val queue: Queue<Int> = LinkedList()
    isVisited[idx] = true
    queue.offer(idx)

    while (queue.isNotEmpty()) {
        val first = queue.poll()

        for (i in graph[first].indices) {
            val next = graph[first][i]
            if (!isVisited[next]) {
                linkedComCount[next]++
                isVisited[next] = true
                queue.offer(next)
            }
        }
    }
}