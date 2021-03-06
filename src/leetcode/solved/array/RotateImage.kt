package leetcode.solved.array

// 48. Rotate Image
// Runtime: 176 ms, faster than 61.07%
// Memory Usage: 35.2 MB, less than 91.60%
fun rotate(matrix: Array<IntArray>) {
    rotation(0, matrix.size-1, matrix)
}

fun rotation(start: Int, end: Int, matrix: Array<IntArray>){
    if (start>=end)
        return
    for(i in 0 until end-start){
        val second = matrix[start+i][end]
        val third = matrix[end][end - i]
        val fourth = matrix[end-i][start]

        matrix[start+i][end] = matrix[start][start+i]
        matrix[end][end - i] = second
        matrix[end-i][start] = third
        matrix[start][start + i] = fourth
    }
    rotation(start+1, end-1, matrix)
}

fun main(){
    val matrix = arrayOf(
        intArrayOf(2 , 29, 20, 26, 16, 28),
        intArrayOf(12, 27, 9 , 25, 13, 21),
        intArrayOf(32, 33, 32, 2 , 28, 14),
        intArrayOf(13, 14, 32, 27, 22, 26),
        intArrayOf(33, 1 , 20, 7 , 21, 7 ),
        intArrayOf(4 , 24, 1 , 6 , 32, 34)
        )
    rotate(matrix)
}
