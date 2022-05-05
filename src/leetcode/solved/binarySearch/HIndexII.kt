package leetcode.solved.binarySearch

// 275. H-Index II
// Runtime: 258 ms, faster than 50.00%
// Memory Usage: 45.4 MB, less than 50.00%

var res = 0
fun hIndex(citations: IntArray): Int {
    searchH(0, citations.lastIndex, citations)
    return res
}

fun searchH(lo: Int, hi: Int, nums: IntArray){
    if(lo>hi)
        return

    val middle = lo + (hi-lo)/2
    val h = nums.lastIndex-middle+1
    if(nums[middle]>=h){
        res = h
        searchH(lo, middle-1, nums)
    } else{
        searchH(middle+1, hi, nums)
    }
}