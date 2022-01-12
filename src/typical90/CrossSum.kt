package typical90

fun main() {
    val reader = System.`in`.bufferedReader()
    val (H, W) = reader.readLine().split(" ").map { it.toInt() }
    val table = MutableList(H) { MutableList(W) {0} }

    val row = MutableList(H) {0}
    val column = MutableList(W) {0}

    for (i in 0 until H) {
        val width = reader.readLine().split(" ").map { it.toInt() }
        for (j in 0 until W) {
            table[i][j] = width[j]
            row[i] += table[i][j]
            column[j] += table[i][j]
        }
    }

    for (i in 0 until H) {
        for (j in 0 until W) {
            table[i][j] = row[i] + column[j] - table[i][j]
        }
    }

    for (width in table) {
        println(width.joinToString(" "))
    }
}