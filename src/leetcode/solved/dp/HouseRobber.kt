package leetcode.solved.dp

// 198. House Robber
// Runtime: 144 ms, faster than 57.98%
// Memory Usage: 35.4 MB, less than 27.73%
fun rob(nums: IntArray): Int {
    if(nums.isEmpty())
        return 0
    if(nums.size == 1)
        return nums[0]
    if(nums.size == 2)
        return Math.max(nums[0], nums[1])

    var twoBefore = nums[0];
    var oneBefore = Math.max(nums[0], nums[1]);

    var curr = 0
    for(i in 2..nums.lastIndex){
        curr = Math.max(nums[i] + twoBefore, oneBefore)
        twoBefore = oneBefore
        oneBefore = curr
    }
    return curr
}