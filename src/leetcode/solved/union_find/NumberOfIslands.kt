package leetcode.solved.union_find

// 200. Number of Islands
// Runtime: 200 ms, faster than 46.53%
// Memory Usage: 47.5 MB, less than 7.26%
fun numIslands(grid: Array<CharArray>): Int {
    val list = ArrayList<Char>()
    for(i in 0..grid.lastIndex){
        for(j in 0..grid.first().lastIndex){
            if(grid[i][j]=='0')
                continue
            when{
                j-1>=0 && i-1>=0 && grid[i][j-1] != '0' && grid[i-1][j] != '0' -> {
                    if(grid[i][j-1]!=grid[i-1][j])
                        list[(grid[i][j-1]).toInt()-50] = list[(grid[i-1][j]).toInt()-50]
                    grid[i][j] = list[(grid[i-1][j]).toInt()-50]
                }
                j-1>=0 && grid[i][j-1] != '0' -> {
                    grid[i][j] = list[(grid[i][j-1]).toInt()-50]
                }
                i-1>=0 && grid[i-1][j] != '0' -> {
                    grid[i][j] = list[(grid[i-1][j]).toInt()-50]
                }
                else -> {
                    grid[i][j] = (list.size+50).toChar()
                    list.add((list.size+50).toChar())
                }
            }
        }
    }
    val hashSet = HashSet<Char>()
    for(i in 0..list.lastIndex){
        var checkingItem = i
        while (list[checkingItem].toInt()-50 != checkingItem){
            checkingItem = list[list[checkingItem].toInt()-50].toInt()-50
        }
        hashSet.add(list[checkingItem])
    }
    return hashSet.size
}

fun main(){
    val sd = arrayOf(
        charArrayOf('1','1','1','1','1','0','1','1','1','1'),
        charArrayOf('1','0','1','0','1','1','1','1','1','1'),
        charArrayOf('0','1','1','1','0','1','1','1','1','1'),
        charArrayOf('1','1','0','1','1','0','0','0','0','1'),
        charArrayOf('1','0','1','0','1','0','0','1','0','1'),
        charArrayOf('1','0','0','1','1','1','0','1','0','0'),
        charArrayOf('0','0','1','0','0','1','1','1','1','0'),
        charArrayOf('1','0','1','1','1','0','0','1','1','1'),
        charArrayOf('1','1','1','1','1','1','1','1','0','1'),
        charArrayOf('1','0','1','1','1','1','1','1','1','0')
    )
    print(numIslands(sd))

}