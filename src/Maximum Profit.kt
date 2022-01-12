import kotlin.math.max
import kotlin.math.min

fun main(args:Array<String>) {
    val n = readLine()!!.toInt()
    val list = List(n) { readLine()!!.toInt() }
    var maxv = -100
    var minv = list[0]
    for (i in 1 until n) {
        maxv = max(maxv,list[i]-minv)
        minv = min(minv,list[i])
    }
    println(maxv)
}