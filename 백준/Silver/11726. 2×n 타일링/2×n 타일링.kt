import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val dp = IntArray(n + 1)

    if (n < 3) println(n)
    else {
        dp[1] = 1
        dp[2] = 2

        for (i in 3..n) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
        }

        println(dp[n] % 10007)
    }
}