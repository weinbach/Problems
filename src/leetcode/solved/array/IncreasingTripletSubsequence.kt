package leetcode.solved.array

//334. Increasing Triplet Subsequence

//Runtime: 188 ms, faster than 22.22%
//Memory Usage: 36.1 MB, less than 16.67%
fun increasingTriplet(nums: IntArray): Boolean {
    var first = 0
    var second = 0
    var found = false

    var i = 0
    while (i in nums.indices) {
        if (!found){
            if (i==nums.size-1)
                return false
            if(nums[i]<nums[i+1]){
                found = true
                first = i
                second = i+1
            }

        } else{
            if(nums[second]< nums[i])
                return true
            if (i<nums.size-1 && nums[i]<nums[second] && nums[first] < nums[i]){
                second = i
                if(nums[second]< nums[i+1])
                    return true
            }
            if(i<nums.size-1 && nums[i]<nums[i+1]){
                if(nums[second]>nums[i+1]){
                    first = i
                    second = i+1
                }
            }
        }
        i++
    }

    return false
}

// [5,1,5,5,2,5,4]
fun main() {
    print(increasingTriplet(intArrayOf(5,1,5,5,2)))

}