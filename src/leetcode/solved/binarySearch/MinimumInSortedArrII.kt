package leetcode.solved.binarySearch

//154. Find Minimum in Rotated Sorted Array II
// Runtime: 220 ms, faster than 5.26%
// Memory Usage: 37.3 MB, less than 42.11%
private fun findMin(nums: IntArray): Int {
    if(nums[0]<nums.last() || nums.size==1)
        return nums[0]
    if(nums.size==2)
        return nums[1]

    return search(0, nums.lastIndex, nums)
}

private fun search(start: Int, end: Int, nums: IntArray): Int{
    if(end<start)
        return nums[0]
    val middle = (end+start+1)/2
    if(nums[middle]<nums[middle-1])
        return nums[middle]

    if(nums[middle]>nums[0])
        return search(middle+1, end, nums)
    else{
        var temp = middle-1
        while(temp>0 && nums[temp]==nums[middle])
            temp--
        if(nums[temp]>nums[middle])
            return nums[middle]
        return if((nums[middle] == nums[0] && temp == 0))
            search(middle+1,  end, nums)
        else
            search(start, temp, nums)

    }
}

fun main(){
    print(findMin(intArrayOf(2,2,2,0,1)))
}