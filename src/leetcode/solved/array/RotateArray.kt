package leetcode.solved.array

// 189. Rotate Array
// Runtime: 356 ms, faster than 30.43%
// Memory Usage: 51.6 MB, less than 11.41%
fun rotate(nums: IntArray, k: Int): Unit {
    var rotation = k%nums.size

    var swaps = 0
    if(rotation == 0)
        return

    var currIndex = 0
    var nextIndex = rotation

    var temp: Int
    while(swaps<nums.size){
        swaps++
        temp = nums[nextIndex]
        nums[nextIndex] = nums[currIndex]
        nums[currIndex] = temp
        nextIndex = (nextIndex+rotation)%nums.size
        if(nextIndex == currIndex){
            swaps++
            currIndex++
            nextIndex = (currIndex+rotation)%nums.size
        }
    }
}