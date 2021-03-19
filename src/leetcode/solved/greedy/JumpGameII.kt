package leetcode.solved.greedy

// 45. Jump Game II
// Runtime: 164 ms, faster than 100.00%
// Memory Usage: 35.3 MB, less than 100.00%
private fun jump(nums: IntArray): Int {
    if(nums.size==1)
        return 0

    return find(nums, 0, 0)
}

private fun find(nums: IntArray, currentIndex: Int, steps: Int): Int {
    if(nums.lastIndex - currentIndex - nums[currentIndex]<1)
        return steps + 1

    var furthestIndex = currentIndex+1
    for(i in currentIndex+1..currentIndex+nums[currentIndex]){
        if(nums[i] == 0)
            continue
        if(nums[i]+i>nums[furthestIndex]+furthestIndex)
            furthestIndex = i
    }

    return find(nums, furthestIndex, steps+1)
}
