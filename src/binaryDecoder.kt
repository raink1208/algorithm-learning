fun main() {
    val binaryString = readLine() ?: return
    val binaryArray = binaryString.chunked(8)
    val byteArray = mutableListOf<Byte>()
    for (i in binaryArray) {
        byteArray.add(Integer.parseInt(i, 2).toByte())
    }
    println(byteArray.toByteArray().toString(Charsets.UTF_8))
}