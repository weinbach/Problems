package leetcode.solved.backtrack

// 79. Word Search
// beats 6% in memory and runtime :D
val searchStartedPoints = HashSet<Pair<Int, Int>>()

fun exist(board: Array<CharArray>, word: String): Boolean {
    val startPoint = Pair(0, 0)
    val passedRoute = HashSet<Pair<Int, Int>>()
    passedRoute.add(startPoint)
    searchStartedPoints.add(startPoint)

    return findRoute(passedRoute, 0, word, board, startPoint)
}

fun findRoute(passedRoute: HashSet<Pair<Int, Int>>, wordIndex: Int, word: String, board: Array<CharArray>, currentPoint: Pair<Int, Int>): Boolean {

    val charMatch = word[wordIndex] == board[currentPoint.first][currentPoint.second]
    if (wordIndex == word.lastIndex && charMatch)
        return true

    // Right
    if (currentPoint.second < board[0].lastIndex && !passedRoute.contains(Pair(currentPoint.first, currentPoint.second + 1))) {
        val point = Pair(currentPoint.first, currentPoint.second + 1)
        if (charMatch) {
            val newPassedRoute = HashSet<Pair<Int, Int>>(passedRoute)
            newPassedRoute.add(point)
            if (findRoute(newPassedRoute, wordIndex + 1, word, board, point)) return true
        }
        if (!searchStartedPoints.contains(point))
            if(startNewSearch(word, board,point)) return true
    }
    // Left
    if (currentPoint.second > 0 && !passedRoute.contains(Pair(currentPoint.first, currentPoint.second - 1))) {
        val point = Pair(currentPoint.first, currentPoint.second - 1)
        if (charMatch) {
            val newPassedRoute = HashSet<Pair<Int, Int>>(passedRoute)
            newPassedRoute.add(point)
            if (findRoute(newPassedRoute, wordIndex + 1, word, board, point)) return true
        }
        if (!searchStartedPoints.contains(point))
            if(startNewSearch(word, board,point)) return true
    }
    // Down
    if (currentPoint.first < board.lastIndex && !passedRoute.contains(Pair(currentPoint.first + 1, currentPoint.second))) {
        val point = Pair(currentPoint.first + 1, currentPoint.second)
        if (charMatch) {
            val newPassedRoute = HashSet<Pair<Int, Int>>(passedRoute)
            newPassedRoute.add(point)
            if (findRoute(newPassedRoute, wordIndex + 1, word, board, point)) return true
        }
        if (!searchStartedPoints.contains(point))
            if(startNewSearch(word, board,point)) return true
    }
    // Top
    if (currentPoint.first > 0 && !passedRoute.contains(Pair(currentPoint.first - 1, currentPoint.second))) {
        val point = Pair(currentPoint.first - 1, currentPoint.second)
        if (charMatch) {
            passedRoute.add(point)
            if (findRoute(passedRoute, wordIndex + 1, word, board, point)) return true
        }
        if (!searchStartedPoints.contains(point))
            if(startNewSearch(word, board,point)) return true
    }

    return false
}

fun startNewSearch(word: String, board: Array<CharArray>, point: Pair<Int, Int>): Boolean {
    searchStartedPoints.add(point)
    val newPassedRoute = HashSet<Pair<Int, Int>>()
    newPassedRoute.add(point)
    return findRoute(newPassedRoute, 0, word, board, point)
}

fun main() {
    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    )
    print(exist(board, "ABCCEF"))
}