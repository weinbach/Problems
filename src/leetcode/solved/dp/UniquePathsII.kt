package leetcode.solved.dp

//63. Unique Paths II
//Runtime: 260 ms, faster than 9.38%
//Memory Usage: 38.6 MB, less than 31.25%
private fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {

    if (obstacleGrid[0][0] == 1)
        return 0

    for (i in 0..obstacleGrid.lastIndex) {
        for (j in 0..obstacleGrid[0].lastIndex) {
            if (obstacleGrid[i][j] == 1) {
                obstacleGrid[i][j] = -1
                continue
            }
            if(i==0 && j==0)
                obstacleGrid[0][0] = 1

            if (i > 0 && obstacleGrid[i - 1][j] != -1)
                obstacleGrid[i][j] += if (obstacleGrid[i - 1][j] == 0) 1 else obstacleGrid[i - 1][j]

            if (j > 0 && obstacleGrid[i][j - 1] != -1)
                obstacleGrid[i][j] += if (obstacleGrid[i][j - 1] == 0) 1 else obstacleGrid[i][j - 1]

            if (obstacleGrid[i][j]==0)
                obstacleGrid[i][j] = -1
        }
    }

    return Math.max(obstacleGrid[obstacleGrid.lastIndex][obstacleGrid[obstacleGrid.lastIndex].lastIndex], 0)
}
