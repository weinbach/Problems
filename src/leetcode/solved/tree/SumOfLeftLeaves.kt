package leetcode.solved.tree

import java.util.*

//404. Sum of Left Leaves
//Runtime: 148 ms, faster than 92.35%
//Memory Usage: 32.8 MB, less than 55.88%
fun sumOfLeftLeaves(root: TreeNode?): Int {
    if (root==null)
        return 0
    val stack = Stack<TreeNode>()
    var curr = root
    var sum = 0
    do {
        val isLeft = if (curr==null) false else curr.left!=null
        while (curr!=null){
            stack.push(curr)
            curr = curr.left
        }
        curr = stack.pop()
        if(isLeft && curr.right==null)
            sum+=curr.`val`
        curr = curr.right

    } while (curr!=null||!stack.isEmpty())
    return sum
}