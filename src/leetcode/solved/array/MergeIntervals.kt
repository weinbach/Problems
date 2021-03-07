package leetcode.solved.array

// 56. Merge Intervals
// Runtime: 240 ms, faster than 93.98%
// Memory Usage: 39 MB, less than 73.09%
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val res = ArrayList<IntArray>()
    val comparator = Comparator { o1: IntArray, o2: IntArray ->
        return@Comparator o1[0].compareTo(o2[0])
    }
    intervals.sortWith(comparator)

    var i = 0
    while (i in 0 .. intervals.lastIndex){
        val currInterval = intervals[i]
        if(i==intervals.lastIndex){
            res.add(currInterval)
            break
        }
        while (i<intervals.lastIndex && currInterval[1]>=intervals[i+1][0]){
            currInterval[1] = Math.max(currInterval[1], intervals[i+1][1])
            i++
        }
        res.add(currInterval)
        i++
    }
    return res.toArray(arrayOfNulls<IntArray>(res.size))
}