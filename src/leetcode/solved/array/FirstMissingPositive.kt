package leetcode.solved.array

import kotlin.math.abs

//41. First Missing Positive

//Runtime: 176 ms, faster than 48.62%
//Memory Usage: 35.9 MB, less than 11.01% 
fun firstMissingPositive(nums: IntArray): Int {

    if(nums.isEmpty())
        return 1

    for(i in 0..nums.lastIndex){
        if(nums[i]<1 || nums[i]>nums.size){
            nums[i] = nums.size+1
        }
    }
    for(i in 0..nums.lastIndex){
        if(abs(nums[i])!=nums.size+1 && nums[abs(nums[i])-1]>0){
            nums[abs(nums[i]) -1] = nums[abs(nums[i])-1]*(-1)
        }
    }
    for(i in 0..nums.lastIndex){
        if(nums[i]>0)
            return i+1
    }

    return nums.size+1

}

fun main(){
    print(firstMissingPositive(intArrayOf(3,4,-1,1)))
}