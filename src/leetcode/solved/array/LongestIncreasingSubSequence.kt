package leetcode.solved.array

//674. Longest Continuous Increasing Subsequence
fun findLengthOfLCIS(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var bestLength = 0

    var tempLength = 1
    for (i in 0 until nums.size - 1) {
        if(tempLength == 1 && nums.lastIndex - i +1 < bestLength)
            return bestLength
        if (nums[i] < nums[i + 1]) {
            tempLength++
        } else {
            if (bestLength < tempLength)
                bestLength = tempLength
            tempLength = 1
        }
    }

    return if (tempLength > bestLength) tempLength else bestLength
}

fun main() {
    print(findLengthOfLCIS(intArrayOf(1,3,5,4,2,3,4,5)))
}