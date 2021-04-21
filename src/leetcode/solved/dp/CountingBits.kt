package leetcode.solved.dp

// 338. Counting Bits
// Runtime: 200 ms, faster than 31.91%
// Memory Usage: 37.9 MB, less than 91.49%
fun countBits(num: Int): IntArray {
    if(num<3){
        val res = IntArray(num+1){1}
        res[0]=0
        return res
    }
    val memo = IntArray(num+1){0}
    memo[0] = 0
    memo[1] = 1
    memo[2] = 1
    memo[3] = 1

    var curr = 4
    var power = 3.0
    var iterator = 0

    while(curr<=num){
        if(curr==Math.pow(2.0, power).toInt()){
            power++
            iterator=0
        }

        memo[curr++] = 1 + memo[iterator++]
    }
    return memo
}