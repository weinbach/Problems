package leetcode.solved.dp

// 72. Edit Distance
// Runtime: 224 ms, faster than 30.43%
// Memory Usage: 38.4 MB, less than 30.43%
private fun minDistance(word1: String, word2: String): Int {
    val matrix = Array<Array<Int>>(word1.length+1){ Array<Int>(word2.length+1){0} }

    for(i in 1..matrix[0].lastIndex){
        matrix[0][i] = i
    }
    for(i in 1..matrix.lastIndex){
        matrix[i][0] = i
    }

    for(i in 1..matrix.lastIndex){
        for(j in 1..matrix[0].lastIndex){
            if(word1[i-1] == word2[j-1])
                matrix[i][j] = matrix[i-1][j-1]
            else
                matrix[i][j] = Math.min(Math.min(matrix[i-1][j-1], matrix[i-1][j]), matrix[i][j-1]) + 1
        }
    }
    return matrix[matrix.lastIndex][matrix[0].lastIndex]
}