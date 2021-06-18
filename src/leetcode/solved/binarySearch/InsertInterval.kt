package leetcode.solved.binarySearch

// 57. Insert Interval
// Runtime: 268 ms, faster than 39.08%
// Memory Usage: 41.7 MB, less than 26.44%
fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    // take central interval
    // if point is less than start -> go to the left /  if it's the most left  then point is between previous and curr
    // if point is greater than end -> go to the right / if it's the most right then point is between curr and next
    // else dot is in range
    if(intervals.isEmpty())
        return Array(1){newInterval}

    val leftPoint = binarySearchPoint(0, intervals.lastIndex, newInterval[0], intervals)
    val rightPoint = binarySearchPoint(leftPoint.toInt(), intervals.lastIndex, newInterval[1], intervals)

    if(leftPoint == rightPoint){
        return if(leftPoint%1==0.0){
            intervals
        } else{
            val array = Array(intervals.size + 1) { i ->
                when {
                    i < leftPoint -> intervals[i]
                    i == (leftPoint + 0.5).toInt() -> newInterval
                    else -> intervals[i - 1]
                }
            }
            array
        }
    }

    newInterval[0] = if(leftPoint%1==0.0) intervals[leftPoint.toInt()][0] else newInterval[0]
    newInterval[1] = if(rightPoint%1==0.0) intervals[rightPoint.toInt()][1] else newInterval[1]

    val leftMerged = (leftPoint +0.5).toInt()
    val rightMerged = rightPoint.toInt()

    return Array(intervals.size-(rightMerged - leftMerged)){i ->
        when {
            i<leftMerged -> intervals[i]
            i==leftMerged -> newInterval
            else -> {
                intervals[i+rightMerged-leftMerged]
            }
        }
    }
}

fun binarySearchPoint(start: Int, end: Int, point: Int, intervals: Array<IntArray>): Double{
    if(start>end)
        return -1.0
    val middle = start+(end-start)/2
    when {
        point<intervals[middle][0] -> {
            if(middle == start)
                return start-0.5
            return binarySearchPoint(start, middle-1, point, intervals)
        }
        point>intervals[middle][1] -> {
            if(middle == end)
                return end+0.5
            return binarySearchPoint(middle+1, end, point, intervals)
        }
        else -> return middle.toDouble()
    }
}

fun main(){
    // [1,2],[3,5],[6,7],[8,10],[12,16]

    val intervals = arrayOf (intArrayOf(1,2),intArrayOf(3,5),intArrayOf(6,7),intArrayOf(8,10),intArrayOf(12,16))
    val newInterval = intArrayOf(4, 8)
    val s  = insert(intervals, newInterval)
    val asd = 2
}