package leetcode.solved.dp

// 70. Climbing Stairs
// Runtime: 124 ms, faster than 73.56%
// Memory Usage: 32.8 MB, less than 43.05%
fun climbStairs(n: Int): Int {
    if(n==1)
        return 1
    val memo = Array(n){0}
    memo[0] = 1
    memo[1] = 2
    return getPossibleWays(memo, n-1)
}

fun getPossibleWays(memo: Array<Int>, n: Int): Int{
    if(memo[n]!=0)
        return memo[n]
    else{
        memo[n] = getPossibleWays(memo, n-1) + getPossibleWays(memo, n-2)
        return memo[n]
    }
}

fun main(){
    climbStairs(4)
}