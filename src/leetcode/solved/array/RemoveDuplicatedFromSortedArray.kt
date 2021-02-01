package leetcode.solved.array

//26. Remove Duplicates from Sorted Array
//Runtime: 360 ms, faster than 12.96%
//Memory Usage: 43.5 MB, less than 13.45%
private fun removeDuplicates(nums: IntArray): Int {
    if(nums.isEmpty())
        return 0
    var i = 1
    var j = 0
    while(i<nums.size){
        if(nums[i]!=nums[j]){
            nums[j+1] = nums[i]
            j++
        }
        i++
    }
    return j+1
}