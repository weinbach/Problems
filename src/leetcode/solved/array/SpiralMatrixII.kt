package leetcode.solved.array

// 59. Spiral Matrix II
// Runtime: 148 ms, faster than 53.85%
// Memory Usage: 33.9 MB, less than 76.92%
fun generateMatrix(n: Int): Array<IntArray> {
    val matrix = Array(n){ IntArray(n) }
    fillLayer(Pair(0,0), Pair(n-1, n-1), 1, matrix)
    return matrix
}
fun fillLayer(start: Pair<Int, Int>, end: Pair<Int, Int>, currNum: Int, matrix: Array<IntArray>){
    var num = currNum

    for(i in start.second..end.second)
        matrix[start.first][i] = num++
    for(i in start.first+1..end.first)
        matrix[i][end.second] = num++
    for(i in end.second-1 downTo start.second)
        matrix[end.first][i] = num++
    for(i in end.first-1 downTo start.first+1)
        matrix[i][start.second] = num++

    if((start.first+1<=end.first-1) && start.second+1<=end.second-1)
        fillLayer(Pair(start.first+1, start.second+1), Pair(end.first-1, end.second-1), num, matrix)
}

fun main(){
    val s =  generateMatrix(3)
    val asd = 2
}
