package leetcode.solved.dp

// 304. Range Sum Query 2D - Immutable
// Runtime: 268 ms, faster than 47.73%
// Memory Usage: 45 MB, less than 79.55%
class NumMatrix() {

    lateinit var matrix: Array<IntArray>

    constructor(matrix: Array<IntArray>): this(){
        this.matrix = matrix
        if(matrix.isNotEmpty())
            constructAreaMatrix()
    }
    private lateinit var areaMatrix: Array<IntArray>

    private fun constructAreaMatrix(){
        areaMatrix = Array<IntArray>(matrix.size+1){
            IntArray(matrix[0].size+1){0}
        }
        for(i in 0..matrix.lastIndex){
            for(j in 0..matrix[0].lastIndex){
                areaMatrix[i+1][j+1] = areaMatrix[i][j+1] + areaMatrix[i+1][j] - areaMatrix[i][j] + matrix[i][j]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return areaMatrix[row2+1][col2+1] - areaMatrix[row1][col2+1] - areaMatrix[row2+1][col1] + areaMatrix[row1][col1]
    }

}

fun main(){
    NumMatrix()
}