import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    val n = sc.nextInt()
    val m = IntArray(n)
    val mT = IntArray(n + 1)
    for (i in 0 until n) m[i] = sc.nextInt()
    for (i in 0 until n) mT[i + 1] = m[i] + mT[i]
    var ans = mT[t] - mT[0]
    var tmp: Int
    for (i in 0 until n - t) {
        tmp = mT[i + 1 + t] - mT[i + 1]
        if (ans < tmp) ans = tmp
    }
    println(ans)
}
