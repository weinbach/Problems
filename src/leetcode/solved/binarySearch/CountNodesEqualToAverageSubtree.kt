package leetcode.solved.binarySearch

import leetcode.solved.tree.TreeNode

// 2265. Count Nodes Equal to Average of Subtree
// Runtime: 229 ms, faster than 74.29%
// Memory Usage: 37.9 MB, less than 65.71%
fun averageOfSubtree(root: TreeNode?): Int {
    if(root!=null) calcAvg(root)
    return avgEquals
}
var avgEquals = 0
fun calcAvg(node: TreeNode): Pair<Int,Int>{

    val left = if(node.left!=null) calcAvg(node.left!!) else null
    val right = if(node.right!=null) calcAvg(node.right!!) else null

    val totalSum = (left?.first?:0) + (right?.first?:0) + node.`val`
    val elements = (left?.second?:0) + (right?.second?:0) + 1

    val average:Int = totalSum/elements
    if(average==node.`val`)
        avgEquals++

    return Pair(totalSum, elements)
}