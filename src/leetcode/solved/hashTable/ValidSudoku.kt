package leetcode.solved.hashTable

// 36. Valid Sudoku
// Runtime: 220 ms, faster than 31.58%
// Memory Usage: 45.6 MB, less than 5.26%
fun isValidSudoku(board: Array<CharArray>): Boolean {
    val maps = Array(3){ Array(9){HashSet<Int>()} }
    var item: Int

    for(i in 0..board.lastIndex){
        for(j in 0..board[0].lastIndex){
            if(board[i][j] == '.')
                continue
            item = board[i][j].toInt()-48

            if(item>9 || item<1)
                return false

            if(maps[0][i].contains(item))
                return false
            maps[0][i].add(item)

            if(maps[1][j].contains(item))
                return false
            maps[1][j].add(item)

            when{
                i<3 -> {
                    when{
                        j<3 -> {
                            if(maps[2][0].contains(item))
                                return false
                            maps[2][0].add(item)
                        }
                        j<6 -> {
                            if(maps[2][1].contains(item))
                                return false
                            maps[2][1].add(item)
                        }
                        else -> {
                            if(maps[2][2].contains(item))
                                return false
                            maps[2][2].add(item)
                        }
                    }
                }
                i<6 -> {
                    when{
                        j<3 -> {
                            if(maps[2][3].contains(item))
                                return false
                            maps[2][3].add(item)
                        }
                        j<6 -> {
                            if(maps[2][4].contains(item))
                                return false
                            maps[2][4].add(item)
                        }
                        else -> {
                            if(maps[2][5].contains(item))
                                return false
                            maps[2][5].add(item)
                        }
                    }
                }
                else -> {
                    when{
                        j<3 -> {
                            if(maps[2][6].contains(item))
                                return false
                            maps[2][6].add(item)
                        }
                        j<6 -> {
                            if(maps[2][7].contains(item))
                                return false
                            maps[2][7].add(item)
                        }
                        else -> {
                            if(maps[2][8].contains(item))
                                return false
                            maps[2][8].add(item)
                        }
                    }
                }
            }

        }
    }
    return true
}

fun main(){
    val asd = arrayOf(
        charArrayOf('5','3','.',   '.','7','.',   '.','.','.'),
        charArrayOf('6','.','.',   '1','9','5',   '.','.','.'),
        charArrayOf('.','9','8',   '.','.','.',   '.','6','.'),

        charArrayOf('8','.','.',   '.','6','.',   '.','.','3'),
        charArrayOf('4','.','.',   '8','.','3',   '.','.','1'),
        charArrayOf('7','.','.',   '.','2','.',   '.','.','6'),

        charArrayOf('.','6','.',   '.','.','.',   '2','8','.'),
        charArrayOf('.','.','.',   '4','1','9',   '.','.','5'),
        charArrayOf('.','.','.',   '.','8','.',   '.','7','9'))
    print(isValidSudoku(asd))
}