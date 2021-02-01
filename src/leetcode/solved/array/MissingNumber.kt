package leetcode.solved.array

//268. Missing Number
//Runtime: 404 ms, faster than 11.47%
//Memory Usage: 52.9 MB, less than 5.10%
private fun missingNumber(nums: IntArray): Int {
    var res = 0
    for(i in 0..nums.lastIndex){
        res = res + 1 + i - nums[i]
    }
    return res
}