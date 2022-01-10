fun main(args: Array<String>) {
    val (n, W) = readLine()!!.split(" ").map { it.toInt() }
    val weight = IntArray(n)
    val cost = IntArray(n)
    for (i in 0 until n) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        cost[i] = a
        weight[i] = b
    }
    val dp = Array(n+10) {IntArray(10010) {0} }
    for (i in 0 until n) {
        for (w in 0..W) {
            if (w >= weight[i]) dp[i+1][w] = (dp[i][w - weight[i]] + cost[i]).coerceAtLeast(dp[i][w])
            else dp[i+1][w] = dp[i][w]
        }
    }

    println(dp[n][W])
}