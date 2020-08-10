package leetcode.solved.tree

//96. Unique Binary Search Trees
fun numTrees(n: Int): Int {
    val memo = arrayOfNulls<Int>(n+1)
    return calculateTees(n, memo)
}

fun calculateTees(n: Int, memo:Array<Int?>): Int {
    var treesNum = 0
    if(n < 1) return 0
    if(n == 2) return 2
    if(n == 1) return 1
    if(memo[n]!=null)
        return memo[n]!!

    for (i in 1..n){
        val leftSubTrees = calculateTees( i - 1, memo)
        val rightSubTrees = calculateTees(n - i, memo)

        treesNum += if(leftSubTrees>0 && rightSubTrees>0){
            leftSubTrees*rightSubTrees
        } else
            leftSubTrees+leftSubTrees
    }
    memo[n] = treesNum
    return treesNum
}

fun main(){
    print(numTrees(5))
}

