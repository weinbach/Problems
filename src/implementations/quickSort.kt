package implementations

fun quickSort(nums: IntArray){
    nums.shuffle()
    quickSort(nums, 0, nums.lastIndex)
    print(isSorted(nums))
}

private fun quickSort(nums: IntArray, start: Int, end: Int){
    if (start>=end)
        return
    val partition = partition(nums, start, end)
    quickSort(nums, start, partition-1)
    quickSort(nums, partition+1, end)
}

private fun partition(nums: IntArray, start: Int, end: Int): Int{
    var left = start+1
    var right = end
    if (start>=end)
        return -1
    while (left<=right){
        while (left<=end && nums[left]<=nums[start])
            left++
        while (right>start && nums[right]>nums[start])
            right--
        if(left>right)
            break
        exchange(left, right, nums)
        left++
        right--
    }

    exchange(start, left-1, nums)
    return left-1
}

fun exchange(a: Int, b: Int, nums: IntArray){
    val temp = nums[a]
    nums[a] = nums[b]
    nums[b] = temp
}

fun isSorted(nums: IntArray): Boolean{
    for (i in 0 until nums.lastIndex)
        if(nums[i]>nums[i+1])
            return false
    return true
}

fun main(){
    for (i in 0..10)
        quickSort(intArrayOf(5,1,1,2,0,0))
}