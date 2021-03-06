package leetcode.solved.array

// 34. Find First and Last Position of Element in Sorted Array
// Runtime: 220 ms, faster than 38.60%
// Memory Usage: 39.8 MB, less than 51.46%

var start: Int = -1
var end: Int = -1

fun searchRange(nums: IntArray, target: Int): IntArray {
    binarySearchStart(target, nums, 0, nums.lastIndex)
    if(start!=-1)
        binarySearchEnd(target, nums, start, nums.lastIndex)
    return intArrayOf(start, end)
}

fun binarySearchStart(target: Int, nums: IntArray, left: Int, right: Int){
    if(left>right)
        return
    val middle = (left+right)/2
    if(nums[middle] == target){
        if(middle == 0)
            start = 0
        else if(nums[middle-1]!=target){
            start = middle
        } else{
            binarySearchStart(target, nums, left, middle-1)
        }
    } else{
        if(nums[middle]>target){
            binarySearchStart(target, nums, left, middle-1)
        } else
            binarySearchStart(target, nums, middle+1, right)
    }
}

fun binarySearchEnd(target: Int, nums: IntArray, left: Int, right: Int){
    if(left>right)
        return
    val middle = (left+right)/2
    if(nums[middle] == target){
        if(middle == nums.lastIndex)
            end = nums.lastIndex
        else if(nums[middle+1]!=target){
            end = middle
        } else{
            binarySearchEnd(target, nums, middle+1, right)
        }
    } else{
        if(nums[middle]>target){
            binarySearchEnd(target, nums, left, middle-1)
        } else
            binarySearchEnd(target, nums, middle+1, right)
    }
}

fun main(){
    val s = searchRange(intArrayOf(5,7,7,8,8,10), 18)
    val asd = 2
}