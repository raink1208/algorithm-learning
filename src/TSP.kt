import java.awt.Point
import java.util.*
import kotlin.collections.ArrayList

fun main(args:Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val points = ArrayList<Point>()
    points.add(Point(0,0))
    for (i in 0 until n) {
        val p = Point(sc.nextInt(),sc.nextInt())
        points.add(p)
    }

    val result = tsp(points)
    info(n+1,result)
}

fun distancePoint(p: Point, q:Point): Double {
    return p.distance(q)
}

fun distanceRoute(n:Int,route:ArrayList<Point>): Double {
    var sum = 0.0
    for (i in 0 until n-1) {
        sum += distancePoint(route[i], route[i+1])
    }
    return sum
}

fun info(n:Int,route:ArrayList<Point>) {
    for (i in 0 until n) {
        println("${route[i].x} ${route[i].y}")
    }
    println("distance: " + distanceRoute(n,route))
}

fun tsp(points: ArrayList<Point>): ArrayList<Point> {
    val resultRoute = ArrayList<Point>()
    val openPoint = ArrayList<Point>(points)
    resultRoute.add(openPoint.removeAt(0))
    while (openPoint.isNotEmpty()) {
        val a:Point = resultRoute[resultRoute.size -1]
        var b:Point? = null
        for (p in openPoint) {
            if (b == null || distancePoint(a,p) < distancePoint(a,b)) {
                b = p
            }
        }
        if (b != null) {
            resultRoute.add(b)
        }
        openPoint.remove(b)
    }
    return resultRoute
}