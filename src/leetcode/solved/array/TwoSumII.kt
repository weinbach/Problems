package leetcode.solved.array

// 167. Two Sum II - Input array is sorted
// Runtime: 196 ms, faster than 44.80%
// Memory Usage: 39.3 MB, less than 20.13%
private fun twoSum(numbers: IntArray, target: Int): IntArray {
    val res = IntArray(2){0}
    for(i in 0 until numbers.lastIndex){

        if(numbers[i]>(target+1)/2)
            break
        var pair = binarySearch(i+1, numbers.lastIndex, numbers, target-numbers[i])
        if(pair>0){
            res[0] = i+1
            res[1] = pair+1
            break
        }

    }

    return res

}

private fun binarySearch(left: Int, right: Int, numbers: IntArray, rest:Int): Int{
    if(left>right)
        return -1
    val middle = (left+right)/2

    if(numbers[middle]==rest)
        return middle

    if(numbers[middle]<rest){
        return binarySearch(middle+1, right, numbers, rest)
    } else{
        return binarySearch(left, middle-1, numbers, rest)
    }
}