import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

private lateinit var networkGraph: Array<ArrayList<Int>>
private lateinit var isVisited: BooleanArray
private var linkedWithCom1 = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val comCount = readLine().toInt()
    val connectionCount = readLine().toInt()
    networkGraph = Array(comCount + 1) { ArrayList() }
    isVisited = BooleanArray(comCount + 1)

    repeat(connectionCount) {
        val (comA, comB) = readLine().split(" ").map { it.toInt() }
        networkGraph[comA].add(comB)
        networkGraph[comB].add(comA)
    }

    bfsStartWithCom1()
    print(linkedWithCom1)
}

private fun bfsStartWithCom1() {
    val queue: Queue<Int> = LinkedList()
    isVisited[1] = true
    queue.add(1)

    while (queue.isNotEmpty()) {
        val first = queue.poll()

        networkGraph[first].forEach { num ->
            if (!isVisited[num]) {
                linkedWithCom1++
                isVisited[num] = true
                queue.offer(num)
            }
        }
    }
}