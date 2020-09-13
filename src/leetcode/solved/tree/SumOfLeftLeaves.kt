package leetcode.solved.tree

import java.util.*

//404. Sum of Left Leaves
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