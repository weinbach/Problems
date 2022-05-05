package leetcode.solved.sort

// 274. H-Index
// Runtime: 208 ms, faster than 66.67%
// Memory Usage: 37.4 MB, less than 16.67%
fun hIndex(citations: IntArray): Int {
    citations.sort()
    var hIndex = 0
    for(i in citations.lastIndex downTo 0){
        if(citations[i]>hIndex){
            hIndex++
        }else
            break
    }

    return hIndex
}