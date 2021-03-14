package leetcode.solved.array

// 766. Toeplitz Matrix
// Runtime: 220 ms, faster than 30.00%
// Memory Usage: 44.5 MB, less than 15.00%
fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
    var column: Int
    var row: Int
    for(i in matrix.lastIndex downTo 0){
        column = 1
        row = i
        while(row+1<=matrix.lastIndex && column<=matrix[0].lastIndex){
            if(matrix[(row++)+1][column++] != matrix[i][0])
                return false
        }
    }

    for (i in matrix[0].lastIndex downTo 1){

        column = i
        row = 1
        while (row<=matrix.lastIndex && column+1<=matrix[0].lastIndex){
            if(matrix[(row++)][(column++)+1] != matrix[0][i])
                return false
        }

    }
    return true
}

fun main(){

    val arr = arrayOf(
            intArrayOf(1,2,3,4),
            intArrayOf(5,11,2,3),
            intArrayOf(9,5,1,2)
    )

    print(isToeplitzMatrix(arr))
}