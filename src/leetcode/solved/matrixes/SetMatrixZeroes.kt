package leetcode.solved.matrixes

// 73. Set Matrix Zeroes
// Runtime: 299 ms, faster than 78.80%
// Memory Usage: 40.6 MB, less than 93.48%
fun setZeroes(matrix: Array<IntArray>): Unit {

    val verticalFill = Array(matrix[0].size){ false }
    val horizontalFill = Array(matrix.size) { false }

    for(i in 0..matrix.lastIndex){
        for(j in 0..matrix[0].lastIndex){
            if(matrix[i][j] == 0){
                verticalFill[j] = true
                horizontalFill[i] = true
            }
        }
    }

    for(i in 0..matrix.lastIndex){
        if(horizontalFill[i]){
            for(j in 0..matrix[0].lastIndex)
                matrix[i][j] = 0
        }
    }

    for(i in 0..matrix[0].lastIndex){
        if(verticalFill[i]){
            for(j in 0..matrix.lastIndex)
                matrix[j][i] =0
        }
    }

}

fun main(){
    val s = Array(2){ false }
}