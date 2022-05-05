package leetcode.solved.binarySearch

// 278. First Bad Version
// Runtime: 334 ms, faster than 41.57%
// Memory Usage: 33.5 MB, less than 35.79%
fun isBadVersion(v: Int): Boolean{
    return true
    // Defined API in Leetcode
}

fun firstBadVersion(n: Int) : Int {
    check(1, n)
    return badVer
}
var badVer = 0
fun check(lo: Int, hi: Int){
    if(lo>hi)
        return

    val mid = lo+(hi-lo)/2
    if(!isBadVersion(mid)){
        check(mid+1, hi)
    } else {
        badVer = mid
        check(lo, mid-1)
    }
}