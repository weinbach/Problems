package leetcode.solved.tree

import java.util.*

//938. Range Sum of BST
fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
    if (root==null)
        return 0

    var sum = 0
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)
    while (!queue.isEmpty()){
        val node: TreeNode = queue.poll()

        if(node.`val` in L..R){
            sum+=node.`val`
        }

        if(node.left!=null && node.`val`>=L)
            queue.add(node.left)

        if(node.right!=null && node.`val`<=R)
            queue.add(node.right)
    }
    return sum
}