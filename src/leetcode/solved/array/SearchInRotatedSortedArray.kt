package leetcode.solved.array

//33. Search in Rotated Sorted Array

//Runtime: 188 ms, faster than 51.14%
//Memory Usage: 36.1 MB, less than 10.68% 
fun search(nums: IntArray, target: Int): Int {

    if (nums.size==1){
        return if (nums[0] == target)
            0
        else -1
    }

    val leftBorder = findArrayRotationPoint(0, nums.lastIndex, nums)
    if(leftBorder<0)
        return customBinarySearch(0, nums.lastIndex, nums, target)

    return if (target<nums[0]){
        customBinarySearch(leftBorder+1, nums.lastIndex, nums, target)
    } else{
        customBinarySearch(0, leftBorder, nums, target)
    }

}

fun findArrayRotationPoint(left: Int, right: Int, array: IntArray): Int{
    if(array.size<2)
        return -1
    //return leftEnd boundary
    val middle: Int = (left+right)/2

    if(array[middle]>array[0]){
        if(middle == array.lastIndex){
            if(middle == 0)
                return -1
            return if(array[middle]<array[middle-1])
                middle
            else
                -1
        }
        return if (array[middle]>array[middle+1])
            middle
        else
            findArrayRotationPoint(middle+1, right, array)
    } else{
        if (middle==0){
            return if(array[middle]>array[middle+1])
                middle
            else
                -1
        }
        return if (array[middle]<array[middle-1])
            middle-1
        else
            findArrayRotationPoint(left, middle-1, array)
    }

}

fun customBinarySearch(left: Int, right: Int, array: IntArray, target: Int): Int{

    if(right-left<0)
        return -1
    if(left == right){
        return if (array[left] == target) left else -1
    }

    val middle = (left+right)/2
    return when{
        array[middle] == target -> middle
        array[middle] > target -> customBinarySearch(left, middle-1, array, target)
        else -> customBinarySearch(middle+1, right, array, target)
    }

}

fun main(){

    val array = intArrayOf(1,3)
    print(search(array, 8))


}