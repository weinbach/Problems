package leetcode.solved.array

// 35. Search Insert Position
// Runtime: 188 ms, faster than 36.36%
// Memory Usage: 36.8 MB, less than 50.00%
fun searchInsert(nums: IntArray, target: Int): Int {
    return binarySearch(target, nums, 0, nums.lastIndex)
}
fun binarySearch(target: Int, nums: IntArray, left: Int, right: Int): Int{
    if(left>right){
        return left
    }
    val middle = (left+right)/2
    if(nums[middle]==target){
        return middle
    }
    if(left==right){
        if(nums[middle]<target)
            return middle+1
        else
            return middle
    }

    if(nums[middle]>target)
        return binarySearch(target, nums, left, middle-1)
    else
        return binarySearch(target, nums, middle+1, right)

}

fun main(){
    print(searchInsert(intArrayOf(1,3,5,6), 7))
}