package leetcode.solved.array

// 643. Maximum Average Subarray I
// Runtime: 416 ms, faster than 44.00%
// Memory Usage: 43.6 MB, less than 32.00%
fun findMaxAverage(nums: IntArray, k: Int): Double {
    var maxSum: Double
    var currSum = 0.0

    for(i in 0 until k)
        currSum+=nums[i]
    maxSum = currSum

    for(i in 1..nums.lastIndex){
        if(nums.lastIndex-i+1<k)
            break
        currSum = currSum-nums[i-1]+nums[i+k-1]
        if(currSum>maxSum)
            maxSum=currSum
    }
    return maxSum/k
}
