package leetcode.solved.dp

// 64. Minimum Path Sum
// Runtime: 192 ms, faster than 66.13%
// Memory Usage: 38.6 MB, less than 56.45%
fun minPathSum(grid: Array<IntArray>): Int {
    if(grid.size==1 && grid[0].size==1)
        return grid[0][0]
    for(i in 0..grid.lastIndex){
        for(j in 0..grid[0].lastIndex){
            if(i==0 && j==0)
                continue
            val top = if(i-1>=0) grid[i-1][j] else Int.MAX_VALUE
            val left = if(j-1>=0) grid[i][j-1] else Int.MAX_VALUE
            grid[i][j] = grid[i][j] + Math.min(top, left)
        }
    }
    return grid[grid.lastIndex][grid[0].lastIndex]
}