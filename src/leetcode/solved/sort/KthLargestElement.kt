package leetcode.solved.sort

import java.util.*
// 215. Kth Largest Element in an Array

// Priority Queues
// Runtime: 344 ms, faster than 5.19%
// Memory Usage: 44.1 MB, less than 5.63%
private fun kthLargestEl(nums: IntArray, k: Int): Int{
    val queue = PriorityQueue(kotlin.Comparator<Int> { o1, o2 ->
        when{
            o1 > o2 -> -1
            o1 < o2 -> 1
            else -> 0
        }
    })
    queue.addAll(nums.asList())

    if(k==1)
        return queue.peek()

    var nth = k - 1
    while (queue.isNotEmpty() && nth>0){
        queue.poll()
        nth--
    }

    return queue.peek()
}

// Quick Select
// Runtime: 232 ms, faster than 28.02%
// Memory Usage: 37.9 MB, less than 11.64%
private fun kthLargestQuick(nums: IntArray, k: Int): Int{
    val s = nums.asList().shuffled().toIntArray()
    return quickSelect(0, nums.lastIndex, s, k)
}

private fun quickSelect(left: Int, right: Int, nums: IntArray, k: Int): Int{
    val partition = partition(left, right, nums)
    if(nums.lastIndex - partition+1 == k)
        return nums[partition]

    return if(nums.lastIndex - partition+1>k){
        quickSelect(partition+1, right, nums, k)
    } else
        quickSelect(left, partition-1, nums, k)

}

private fun partition(left: Int, right: Int, nums: IntArray): Int{
    var start = left+1
    var end = right

    while (start<=end){
        while (start<=right && nums[start]<nums[left]){
            start++
        }
        while (end>=left && nums[end]>=nums[left]){
            end--
        }
        if(start>end)
            continue
        val temp = nums[start]
        nums[start++] = nums[end]
        nums[end--] = temp
    }
    val temp = nums[start-1]
    nums[start-1] = nums[left]
    nums[left] = temp

    return start-1
}