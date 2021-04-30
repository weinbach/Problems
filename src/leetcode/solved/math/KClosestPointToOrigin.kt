package leetcode.solved.math

// 973. K Closest Points to Origin
// Runtime: 648 ms, faster than 27.47%
// Memory Usage: 62.5 MB, less than 32.42%
data class MutablePair(var first: Int, var second: Int)

fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    val distances = Array(points.size){ MutablePair(0,0) }
    val res = Array<IntArray>(k){IntArray(2){0}}
    var tempDistance: Double

    for(i in 0..points.lastIndex){
        tempDistance = Math.pow((0.0-points[i][0]), 2.0) + Math.pow((0.0-points[i][1]), 2.0)
        distances[i].first = tempDistance.toInt()
        distances[i].second = i
    }

    val comparator = Comparator<MutablePair>{ one, two ->
        var result = 0
        when{
            one.first > two.first -> result = 1
            one.first == two.first -> result = 0
            one.first < two.first -> result = -1
        }
        result
    }


    distances.sortWith(comparator)
    for(i in 0 until k){
        res[i][0] = points[distances[i].second][0]
        res[i][1] = points[distances[i].second][1]
    }

    return res
}

fun main(){
    //print(getKthNearestPoint(arrayOf(Pair(1,3), Pair(-2,2)), 1))
    print("213")
}