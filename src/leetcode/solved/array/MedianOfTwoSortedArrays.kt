package leetcode.solved.array

//4. Median of Two Sorted Arrays

//Runtime: 560 ms, faster than 12.44%
//Memory Usage: 53.6 MB, less than 19.82%
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

    val empty = if (nums1.isEmpty()) nums2 else (if (nums2.isEmpty()) nums1 else null)
    if (empty != null) {
        return if (empty.size % 2 != 0)
            empty[empty.size / 2].toDouble()
        else
            (empty[empty.size / 2 - 1] + empty[empty.size / 2].toDouble()) / 2
    }

    val numsOneBigger = nums1.size > nums2.size
    val minArr = if (numsOneBigger) nums2 else nums1
    val maxArr = if (numsOneBigger) nums1 else nums2

    val even = (nums1.size + nums2.size) % 2 != 0
    val portionIndex = binarySearchPartition(minArr, maxArr, 0, minArr.lastIndex)

    val downLeft = (1 + minArr.size + maxArr.size) / 2 - portionIndex - 2

    val left =
            if (portionIndex < 0) {
                maxArr[if (downLeft < 0) 0 else downLeft]
            } else {
                if (downLeft < 0)
                    minArr[portionIndex]
                else
                    max(minArr[portionIndex], maxArr[downLeft])
            }
    val right =
            if (portionIndex + 1 > minArr.lastIndex) {
                maxArr[downLeft + 1]
            } else {
                if (downLeft + 1 > maxArr.lastIndex)
                    minArr[portionIndex + 1]
                else
                    min(minArr[portionIndex + 1], maxArr[downLeft + 1])
            }

    return if(even) left.toDouble() else (left.toDouble()+right)/2

}

fun binarySearchPartition(minArr: IntArray, maxArr: IntArray, left: Int, right: Int): Int {

    val upLeft = (left + right) / 2
    val upRight = upLeft + 1
    val downLeft = (1 + minArr.size + maxArr.size) / 2 - upLeft - 2
    val downRight = downLeft + 1

    if (downLeft < 0) {
        return if (minArr[0] > maxArr[0])
            -1
        else 0
    }
    return if (minArr[upLeft] > maxArr[downRight]) {
        if (upLeft == 0)
            return -1
        binarySearchPartition(minArr, maxArr, left, upLeft - 1)
    } else {
        if (minArr.lastIndex < upRight)
            return upLeft
        if (minArr[upRight] >= maxArr[downLeft])
            upLeft
        else
            binarySearchPartition(minArr, maxArr, upLeft + 1, right)
    }

}

fun min(one: Int, two: Int): Int {
    return if (one > two)
        two
    else
        one
}

fun max(one: Int, two: Int): Int {
    return if (one > two)
        one
    else
        two
}

fun main() {
    print(findMedianSortedArrays(intArrayOf(30,31,32), intArrayOf(1, 2, 4)))
}