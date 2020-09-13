package leetcode.solved.tree

import java.util.*

//235. Lowest Common Ancestor of a Binary Search Tree
fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if(root == p || root == q){
        return root
    }
    val left = if(root!!.left!=null) lowestCommonAncestor(root.left, p, q) else null
    val right = if(root.right!=null) lowestCommonAncestor(root.right, p, q) else null

    if(left!=null && right!=null)
        return root
    return left ?: right
}
