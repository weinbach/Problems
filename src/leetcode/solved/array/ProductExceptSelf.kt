package leetcode.solved.array

// 238. Product of Array Except Self
// Runtime: 320 ms, faster than 38.72%
// Memory Usage: 47.5 MB, less than 18.72%
fun productExceptSelf(nums: IntArray): IntArray {
    val res = IntArray(nums.size){1}
    for(i in 1..res.lastIndex){
        res[i] = res[i-1]*nums[i-1]
    }

    var right = 1

    for(i in res.lastIndex downTo 0){
        res[i] = res[i] * right
        right *= nums[i]
    }

    return res
}