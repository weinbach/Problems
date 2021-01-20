package leetcode.solved.array

//55. Jump Game
//Runtime: 204 ms, faster than 55.32%
//Memory Usage: 37.2 MB, less than 52.13%
private fun canJump(nums: IntArray): Boolean {
    var currIndex = nums.lastIndex

    for(i in nums.lastIndex-1 downTo 0){
        if (i+nums[i]>= currIndex){
            currIndex = i
        }
    }
    return currIndex==0
}

