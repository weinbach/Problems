package leetcode.solved.backtrack

// 78. Subsets
// Runtime: 188 ms, faster than 59.60%
// Memory Usage: 37 MB, less than 31.79%
val arr = ArrayList<ArrayList<Int>>()

fun subsets(nums: IntArray): List<List<Int>> {
    val emptySubSet = ArrayList<Int>()
    arr.add(emptySubSet)
    makeSubset(emptySubSet, 0, nums)
    return arr
}

fun makeSubset(subset: ArrayList<Int>, index: Int, nums: IntArray){
    for(i in index..nums.lastIndex){
        val newSubSet = ArrayList<Int>(subset)
        newSubSet.add(nums[i])
        arr.add(newSubSet)
        makeSubset(newSubSet, i+1, nums)
    }
}