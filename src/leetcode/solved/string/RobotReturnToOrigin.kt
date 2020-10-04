package leetcode.solved.string

//657. Robot Return to Origin

//Runtime: 180 ms, faster than 97.67%
//Memory Usage: 35.1 MB, less than 34.88%
fun judgeCircle(moves: String): Boolean {
    val arr = intArrayOf(0,0)
    for (char in moves) {
        when (char) {
            'U' -> arr[0] = arr[0] + 1
            'R' -> arr[1] = arr[1] + 1
            'L' -> arr[1] = arr[1] - 1
            'D' -> arr[0] = arr[0] - 1
        }
    }
    return arr[0] == 0 && arr[1] == 0
}