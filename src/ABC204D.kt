import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    readLine()
    val dp = BooleanArray(100001)
    dp[0] = true
    var total = 0
    for (time in readLine()!!.split(" ").map { it.toInt() }) {
        total += time
        for (x in 100000 downTo time) {
            dp[x] = dp[x] || dp[x - time]
        }
    }

    var ans = total
    for (x in 0..100000) {
        if (dp[x]) {
            ans = min(ans, max(x, total - x))
        }
    }
    println(ans)
}