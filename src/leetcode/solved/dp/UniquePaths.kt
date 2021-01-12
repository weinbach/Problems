package leetcode.solved.dp

//62. Unique Paths
//Runtime: 144 ms, faster than 35.11%
//Memory Usage: 33.3 MB, less than 22.34%
private var height = 0
private var width = 0

private fun uniquePaths(m: Int, n: Int): Int{
    val memo = Array(m) { IntArray(n) }
    height = m
    width = n
    return findPaths(m, n, memo)
}

private fun findPaths(m: Int, n: Int, memo: Array<IntArray>): Int {
    var count = 0

    if(m==1 || n==1){
        count = 1
    }else{
        if(memo[m-1][n-1] != 0)
            return memo[m-1][n-1]
        else{
            if(m>1)
                count += findPaths(m-1,n, memo)
            if(n>1)
                count += findPaths(m, n-1, memo)
        }
    }
    memo[m-1][n-1] = count
    if(n-1< height && m-1< width)
        memo[n-1][m-1] = count
    return count
}

fun main(){
    print(uniquePaths(51,9))
}
