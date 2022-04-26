import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

var stoneCount = 0
var maxJumpEnergy = 0
var answer = Int.MAX_VALUE
lateinit var energyCost: Array<IntArray>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    stoneCount = readLine().toInt()
    energyCost = Array(stoneCount) { IntArray(2) }
    for (i in 1 until stoneCount) {
        val (smallJump, bigJump) = readLine().split(" ").map { it.toInt() }
        energyCost[i][0] = smallJump
        energyCost[i][1] = bigJump
    }
    maxJumpEnergy = readLine().toInt()

    jump(0, 1, true)
    println(answer)
}

private fun jump(totalEnergy: Int, destination: Int, isAvailableMaxJump: Boolean) {
    if (destination == stoneCount) {
        answer = min(answer, totalEnergy)
        return
    }

    if (destination > stoneCount) return

    jump(totalEnergy + energyCost[destination][0], destination + 1, isAvailableMaxJump)
    jump(totalEnergy + energyCost[destination][1], destination + 2, isAvailableMaxJump)

    if (isAvailableMaxJump) {
        jump(totalEnergy + maxJumpEnergy, destination + 3, false)
    }
}