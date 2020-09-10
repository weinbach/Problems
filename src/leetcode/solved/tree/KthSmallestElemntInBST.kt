package leetcode.solved.tree

import java.util.*

//230. Kth Smallest Element in a BST

//Runtime: 220 ms, faster than 54.02%
//Memory Usage: 36.4 MB, less than 55.17%
fun kthSmallest(root: TreeNode?, k: Int): Int {
    val stack = Stack<TreeNode>()
    var curr: TreeNode? = root
    var count = 1

    do {
        while (curr!=null){
            stack.push(curr)
            curr = curr.left
        }
        curr = stack.pop()
        if(count++==k)
            return curr.`val`

        curr = curr.right

    } while (curr!=null || !stack.isEmpty())

    return 0
}