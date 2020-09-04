package leetcode.solved.tree

import java.util.*

//114. Flatten Binary Tree to Linked List
fun flatten(root: TreeNode?): Unit {
    if(root==null)
        return
    val stack = Stack<TreeNode>()
    stack.push(root)

    while (!stack.empty()){
        val node = stack.pop()

        if (node.right!=null)
            stack.push(node.right)

        if(node.left!=null){
            stack.push(node.left)
            node.left = null
        }

        if(!stack.isEmpty())
            node.right = stack.peek()
    }
}