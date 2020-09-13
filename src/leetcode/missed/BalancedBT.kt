package leetcode.missed

import leetcode.solved.tree.TreeNode

//110. Balanced Binary Tree
fun isBalanced(root: TreeNode?): Boolean {
    if(root==null)
        return true

    val list = leavesDepth(root, 0)
    if((root.left==null) xor (root.right==null)){
        list.add(1)
    }
    return list.max()!!-list.min()!! <= 1
}

fun leavesDepth(node: TreeNode, depth: Int): ArrayList<Int>{
    val list = ArrayList<Int>()

    if(node.left==null && node.right==null){
        list.add(depth+1)
        return list
    } else{
        if(node.left!=null)
            list.addAll(leavesDepth(node.left!!, depth + 1))
        if(node.right!=null)
            list.addAll(leavesDepth(node.right!!, depth + 1))
    }

    return list
}

fun main(){
    val root = TreeNode(1)

    root.left = TreeNode(1)
    root.left!!.right = TreeNode(3)

    root.right = TreeNode(1)
    root.right!!.left = TreeNode(1)
    root.right!!.right = TreeNode(1)
    root.right!!.left!!.left = TreeNode(1)



    isBalanced(root)
}