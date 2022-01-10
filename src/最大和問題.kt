import kotlin.math.max

fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()
    val input = reader.readLine().split(" ").map { it.toInt() }

    val dp = mutableListOf<Int>()
    dp.add(0)
    for (i in 0 until n) {
        dp.add(i+1,max(dp[i], dp[i] + input[i]))
    }

    println(dp[n])
}