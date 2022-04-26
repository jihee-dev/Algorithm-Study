import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val coin = IntArray(n)
    for (i in 0 until n) {
        coin[i] = readLine().toInt()
    }
    
    val dp = IntArray(k + 1)
    dp[0] = 1
    
    for (i in 0 until n) {
        for (j in coin[i]..k) {
            dp[j] += dp[j - coin[i]]
        }
    }
    
    println(dp[k])
}