package leetcode.solved.union_find

// 959. Regions Cut By Slashes
// Runtime: 220 ms, faster than 50.00%
// Memory Usage: 42.9 MB, less than 25.00%

// cell coverage:
// [-1] NOT COVERED;
// [2] COVERED LEFT;
// [3] COVERED RIGHT;
// [1] COVERED COMPLETELY;

// coverage from
// [4] - from left
// [5] - from bottom
// [6] - from right
// [7] - from top
// [8] - from nowhere
fun regionsBySlashes(grid: Array<String>): Int {
    var regions = 0
    val covered = HashMap<Pair<Int, Int>, Int>()

    fun coverCell(cell: Pair<Int, Int>, covFrom: Int): Boolean {
        if (!covered.contains(cell))
            covered[cell] = -1

        fun goTo(side: Int): Boolean {
            when (side) {
                4 -> { // go to left
                    return if (cell.second > 0)
                        coverCell(Pair(cell.first, cell.second - 1), 6)
                    else
                        false
                }
                5 -> {
                    return if (cell.first < grid.lastIndex)
                        coverCell(Pair(cell.first + 1, cell.second), 7)
                    else
                        false
                }
                6 -> {
                    return if (cell.second < grid[0].lastIndex)
                        coverCell(Pair(cell.first, cell.second + 1), 4)
                    else
                        false
                }
                7 -> {
                    return if (cell.first > 0)
                        coverCell(Pair(cell.first - 1, cell.second), 5)
                    else
                        false
                }
            }
            return true
        }

        when (covered[cell]) {
            2 -> {
                when (grid[cell.first][cell.second]) {
                    '\\' -> {
                        when (covFrom) {
                            4, 5 -> return false
                            6 -> {
                                covered[cell] = 1
                                goTo(7)
                            }
                            7 -> {
                                covered[cell] = 1
                                goTo(6)
                            }
                            8 -> {
                                regions++
                                covered[cell] = 1
                                goTo(6)
                                goTo(7)
                            }
                            else -> {
                            }
                        }
                    }
                    else -> { // '/'
                        when (covFrom) {
                            4, 7 -> return false
                            5 -> {
                                covered[cell] = 1
                                goTo(6)
                            }
                            6 -> {
                                covered[cell] = 1
                                goTo(5)
                            }
                            8 -> {
                                covered[cell] = 1
                                regions++
                                goTo(5)
                                goTo(6)
                            }
                            else -> {
                            }
                        }
                    }
                }
            }
            3 -> { // covered right
                when (grid[cell.first][cell.second]) {
                    '\\' -> {
                        when (covFrom) {
                            6, 7 -> return false
                            4 -> {
                                covered[cell] = 1
                                goTo(5)
                            }
                            5 -> {
                                covered[cell] = 1
                                goTo(4)
                            }
                            8 -> {
                                regions++
                                covered[cell] = 1
                                goTo(4)
                                goTo(5)
                            }
                            else -> {
                            }
                        }
                    }
                    else -> {
                        when (covFrom) {
                            5, 6 -> return false
                            4 -> {
                                covered[cell] = 1
                                goTo(7)
                            }
                            7 -> {
                                covered[cell] = 1
                                goTo(4)
                            }
                            8 -> {
                                regions++
                                covered[cell] = 1
                                goTo(7)
                                goTo(4)
                            }
                            else -> {
                            }
                        }
                    }
                }
            }
            -1 -> {
                when (grid[cell.first][cell.second]) {
                    '\\' -> {
                        when (covFrom) {
                            4 -> {
                                covered[cell] = 2
                                goTo(5)
                            }
                            5 -> {
                                covered[cell] = 2
                                goTo(4)
                            }
                            6 -> {
                                covered[cell] = 3
                                goTo(7)
                            }
                            7 -> {
                                covered[cell] = 3
                                goTo(6)
                            }
                            8 -> { // only one case -> cell(0,0)
                                covered[cell] = 1
                                regions++
                                goTo(5)
                                if(goTo(6))
                                    regions++
                            }
                            else -> {
                            }
                        }
                    }
                    '/' -> {
                        when (covFrom) {
                            4 -> {
                                covered[cell] = 2
                                goTo(7)
                            }
                            5 -> {
                                covered[cell] = 3
                                goTo(6)
                            }
                            6 -> {
                                covered[cell] = 3
                                goTo(5)
                            }
                            7 -> {
                                covered[cell] = 2
                                goTo(4)
                            }
                            8 -> {
                                covered[cell] = 1
                                regions++
                                if(goTo(5))
                                    regions++
                                goTo(6)
                            }
                            else -> {
                            }
                        }
                    }
                    else -> { // ' '
                        when (covFrom) {
                            4 -> {
                                covered[cell] = 1
                                goTo(5)
                                goTo(6)
                                goTo(7)
                            }
                            5 -> {
                                covered[cell] = 1
                                goTo(4)
                                goTo(6)
                                goTo(7)
                            }
                            6 -> {
                                covered[cell] = 1
                                goTo(4)
                                goTo(5)
                                goTo(7)
                            }
                            7 -> {
                                covered[cell] = 1
                                goTo(4)
                                goTo(5)
                                goTo(6)
                            }
                            8 -> {
                                regions++
                                covered[cell] = 1
                                goTo(4)
                                goTo(5)
                                goTo(6)
                                goTo(7)
                            }
                            else -> {
                            }
                        }
                    }
                }
            }
            else -> {
                return false
            }
        }
        return true
    }

    for (i in 0..grid.lastIndex)
        for (j in 0..grid[i].lastIndex)
            coverCell(Pair(i, j), 8)

    return regions
}

fun main() {
    print(regionsBySlashes(arrayOf("\\ \\ ","\\/ /","/\\\\\\","\\ / ")))

}
