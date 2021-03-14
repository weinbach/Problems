package leetcode.solved.array

// 54. Spiral Matrix
// Runtime: 152 ms, faster than 58.57%
// Memory Usage: 36.2 MB, less than 17.14%
fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val res = ArrayList<Int>()
    val layers = (Math.min(matrix.size, matrix[0].size)+1)/2-1
    spiral(0, matrix, res, layers)
    return res
}

fun spiral(startLayer: Int, matrix: Array<IntArray>, arr: ArrayList<Int>, layers: Int){
    if(startLayer>layers)
        return

    for(i in startLayer..matrix[0].lastIndex-startLayer)
        arr.add(matrix[startLayer][i])

    for(i in startLayer+1..matrix.lastIndex-startLayer)
        arr.add(matrix[i][matrix[0].lastIndex-startLayer])

    if(startLayer+1>matrix.lastIndex-startLayer)
        return

    for(i in matrix[0].lastIndex-startLayer-1 downTo 0+startLayer)
        arr.add(matrix[matrix.lastIndex-startLayer][i])

    if(matrix[0].lastIndex-startLayer-1<0+startLayer)
        return

    for(i in matrix.lastIndex-startLayer-1 downTo 0+startLayer+1)
        arr.add(matrix[i][startLayer+0])

    spiral(startLayer+1, matrix, arr, layers)
}

fun main(){
    val asd = arrayOf(intArrayOf(7), intArrayOf(9), intArrayOf(6))
    spiralOrder(asd)
}