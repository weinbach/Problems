package leetcode.solved.binarySearch

// 153. Find Minimum in Rotated Sorted Array
// Runtime: 196 ms, faster than 9.71%
// Memory Usage: 37.5 MB, less than 25.24%
fun findMin(nums: IntArray): Int {
    if(nums[0]<=nums.last())
        return nums[0]
    if(nums.size==2)
        return nums[1]

    return search(0, nums.lastIndex, nums)
}

fun search(start: Int, end: Int, nums: IntArray): Int{
    if(end<start)
        return -1
    val middle = (end+start+1)/2
    if(nums[middle]<nums[middle-1])
        return nums[middle]
    else if(nums[middle]>nums[0])
        return search(middle+1, end, nums)
    else return search(start, middle-1, nums)
}

fun main(){
    print(findMin(intArrayOf(5,1,2,3,4)))
}