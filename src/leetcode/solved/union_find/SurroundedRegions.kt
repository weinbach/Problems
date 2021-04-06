package leetcode.solved.union_find

import java.util.*

// 130. Surrounded Regions
// Runtime: 228 ms, faster than 46.30%
// Memory Usage: 40.3 MB, less than 53.70%
fun solve(board: Array<CharArray>): Unit {
    if (board.size < 3)
        return
    val matrix = Array(board.size) { Array(board.first().size) { 0 } }

    connectFromTop(matrix, board, Pair(0, 0), 0)

    for (i in matrix){
        println(Arrays.toString(i))
    }
    for (i in 1 until board.lastIndex) {
        for (j in 1 until board.first().lastIndex) {
            if (board[i][j] == 'X')
                continue
            if (matrix[i][j] != 1)
                board[i][j] = 'X'
        }
    }
}
// 0 - top, 1 - bot, 2 - left, 3 - right
fun connectFromTop(matrix: Array<Array<Int>>, board: Array<CharArray>, point: Pair<Int, Int>, comeFrom: Int) {
    if (board[point.first][point.second] == 'X') {
        if (point.first == 0 && point.second + 1 <= matrix.first().lastIndex)
            connectFromTop(matrix, board, Pair(point.first, point.second + 1),2)

        if (point.second == 0 && point.first + 1 <= matrix.lastIndex)
            connectFromTop(matrix, board, Pair(point.first + 1, point.second), 0)

        if (point.first == matrix.lastIndex && point.second + 1 <= matrix.first().lastIndex)
            connectFromTop(matrix, board, Pair(point.first, point.second +1), 2)

        if (point.second == matrix.first().lastIndex && point.first+1<=matrix.lastIndex)
            connectFromTop(matrix, board, Pair(point.first+1, point.second), 0)
        return
    }
    if (matrix[point.first][point.second] == 1)
        return
    matrix[point.first][point.second] = 1

    if (point.first + 1 <= matrix.lastIndex && comeFrom != 1)
        connectFromTop(matrix, board, Pair(point.first + 1, point.second), 0)

    if (point.second + 1 <= matrix.first().lastIndex && comeFrom != 3)
        connectFromTop(matrix, board, Pair(point.first, point.second + 1), 2)

    if (point.first - 1 >= 0 && comeFrom != 0)
        connectFromTop(matrix, board, Pair(point.first - 1, point.second), 1)

    if (point.second - 1 >= 0 && comeFrom != 2)
        connectFromTop(matrix, board, Pair(point.first, point.second - 1), 3)
}


fun main() {
    val arr = arrayOf(
        charArrayOf('X','O','X','O','O','O','O'),
        charArrayOf('X','O','O','O','O','O','O'),
        charArrayOf('X','O','O','O','O','X','O'),
        charArrayOf('O','O','O','O','X','O','X'),
        charArrayOf('O','X','O','O','O','O','O'),
        charArrayOf('O','O','O','O','O','O','O'),
        charArrayOf('O','X','O','O','O','O','O')
    )
    solve(arr)
}

// ['X','O','X','O','O','O','O'],
// ['X','O','O','O','O','O','O'],
// ['X','O','O','O','O','X','O'],
// ['O','O','O','O','X','O','X'],
// ['O','X','O','O','O','O','O'],
// ['O','O','O','O','O','O','O'],
// ['O','X','O','O','O','O','O']]

// [['X','O','X','O','O','O','O'],
//  ['X','O','O','O','O','O','O'],
//  ['X','O','O','O','O','X','O'],
//  ['O','O','O','O','X','X','X'],
//  ['O','X','O','O','O','O','O'],
//  ['O','O','O','O','O','O','O'],
//  ['O','X','O','O','O','O','O']]
