package leetcode.solved.union_find

//695. Max Area of Island
//Runtime: 224 ms, faster than 46.30%
//Memory Usage: 44.2 MB, less than 20.37%
fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    val islands = ArrayList<Int>()
    val area = ArrayList<Int>()

    fun expandArea(top: Boolean, a: Int, b: Int) {
        val island: Int = if (top)
            grid[a - 1][b]
        else
            grid[a][b - 1]

        grid[a][b] = island
        area[island - 2] = area[island - 2] + 1
    }

    fun getIslandHead(island: Int): Int {
        var head = island
        while (islands[head - 2] != head)
            head = islands[head-2]
        return head
    }

    for (i in 0..grid.lastIndex) {
        for (j in 0..grid[0].lastIndex) {

            val cell = grid[i][j]
            if (cell == 0)
                continue

            val topLand = i - 1 >= 0 && grid[i - 1][j] != 0
            val leftLand = j - 1 >= 0 && grid[i][j - 1] != 0

            when {
                topLand && leftLand -> {
                    grid[i][j] = grid[i][j - 1]
                    area[grid[i][j - 1] - 2] = area[grid[i][j - 1] - 2] + 1
                    islands[getIslandHead(islands[grid[i - 1][j] - 2])-2] = getIslandHead(grid[i][j - 1])
                }
                topLand -> expandArea(true, i, j)
                leftLand -> expandArea(false, i, j)
                else -> {
                    islands.add(islands.size + 2)
                    area.add(1)
                    grid[i][j] = islands.last()
                }
            }
        }
    }

    val hashMap = HashMap<Int, Int>()
    for (i in 0..islands.lastIndex) {
        val head = getIslandHead(islands[i])
        if (!hashMap.contains(head)) {
            hashMap[head] = area[i]
        } else {
            hashMap[head] = hashMap[head]!! + area[i]
        }
    }

    var maxArea = 0
    for (i in hashMap) {
        if (i.value > maxArea)
            maxArea = i.value
    }
    return maxArea   
}

fun main() {
    print(maxAreaOfIsland(arrayOf(
            intArrayOf(1,1,1,0,1,0,1,1,1,1,1,1,0,1,1,0,1,0,1),
            intArrayOf(0,0,0,1,1,0,1,1,1,0,1,1,1,1,1,1,0,1,1),
            intArrayOf(1,0,0,1,0,1,0,0,1,1,1,1,0,0,0,1,0,1,0),
            intArrayOf(0,0,0,0,1,0,0,1,0,1,0,0,0,1,1,1,0,1,0),
            intArrayOf(1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,1,1,0,1),
            intArrayOf(1,0,0,1,1,1,1,1,1,1,0,1,0,0,1,1,1,1,1),
            intArrayOf(1,0,1,0,1,1,0,1,1,0,0,0,1,1,1,1,1,1,1),
            intArrayOf(1,0,1,0,1,1,1,0,1,0,1,0,1,1,0,0,1,1,0),
            intArrayOf(0,1,0,0,0,1,0,1,1,1,1,1,0,0,0,1,0,0,0)
    )))
}