package leetcode.solved.array

// 169. Majority Element
// Runtime: 228 ms, faster than 60.61%
// Memory Usage: 43.5 MB, less than 13.33%

// Boyer-Moore Voting Algorithm
fun majorityElement(nums: IntArray): Int {
    var count = 1
    var me = nums[0]

    for(i in 1..nums.lastIndex){
        if(nums[i]!=me){
            if(--count==0){
                me = nums[i]
                count=1
            }
        }else{
            count++
        }
    }
    return me
}