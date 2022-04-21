package leetcode.solved.binarySearch

// 74. Search a 2D Matrix
// Runtime: 202 ms, faster than 74.65%
// Memory Usage: 36 MB, less than 75.66%
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val row = matrixBS(matrix, target, 0, matrix.lastIndex)
    print(row)
    return if(row == -1)
        false
    else
        bs(matrix[row], 0, matrix[row].lastIndex, target)
}

fun matrixBS(matrix: Array<IntArray>, target: Int, lo: Int, hi: Int): Int {
    if(lo>hi) return -1
    val middle = lo + ((hi - lo) / 2)
    return when {
        matrix[middle][0] > target -> matrixBS(matrix, target, lo, middle - 1)
        target <= matrix[middle].last() -> middle
        else -> matrixBS(matrix, target, middle + 1, hi)
    }
}

fun bs(nums: IntArray, lo: Int, hi: Int, target: Int): Boolean {
    val middle = lo + ((hi - lo) / 2)
    return when {
        hi < lo -> false
        nums[middle] == target -> true
        target > nums[middle] -> bs(nums, middle + 1, hi, target)
        else -> bs(nums, lo, middle - 1, target)
    }
}

