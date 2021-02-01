package leetcode.solved.array

//88. Merge Sorted Array
//Runtime: 276 ms, faster than 10.79%
//Memory Usage: 35.3 MB, less than 94.21%
private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = m-1
    var j = n-1

    while(j>=0){
        if(i>=0 && nums1[i]>nums2[j]){
            nums1[i+j+1] = nums1[i]
            i--
        } else{
            nums1[i+j+1] = nums2[j]
            j--
        }
    }
}

fun main(){
    merge(intArrayOf(2,5,6,0,0,0), 3, intArrayOf(1,2,3), 3)
}