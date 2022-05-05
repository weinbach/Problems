package leetcode.solved.array

// 162. Find Peak Element
// Runtime: 265 ms, faster than 56.08%
// Memory Usage: 39.2 MB, less than 20.78%
fun findPeakElement(nums: IntArray): Int {
    for(i in 0..nums.lastIndex){
        val left = if(i==0) true else nums[i]> nums[i-1]
        val right = if(i==nums.lastIndex) true else nums[i]>nums[i+1]
        if(left && right)
            return i
    }
    return 0
}