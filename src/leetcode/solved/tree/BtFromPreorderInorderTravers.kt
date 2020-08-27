package leetcode.solved.tree

//105. Construct Binary Tree from Preorder and Inorder Traversal
private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty())
        return null
    if (preorder.size == 1)
        return TreeNode(preorder[0])

    val node = TreeNode(preorder[0])
    val inorderLeftNodesEdge = inorder.indexOf(preorder[0])
    val preorderLeftNodesEdge = 1 + inorderLeftNodesEdge

    node.left = buildTree(preorder.copyOfRange(1, preorderLeftNodesEdge), inorder.copyOfRange(0, inorderLeftNodesEdge))
    if(preorderLeftNodesEdge<=preorder.lastIndex)
        node.right = buildTree(preorder.copyOfRange(preorderLeftNodesEdge, preorder.lastIndex+1), inorder.copyOfRange(preorderLeftNodesEdge, inorder.lastIndex+1))

    return node
}

fun main() {
    val preorder = intArrayOf(1,2,3)
    val inorder = intArrayOf(3,2,1)

    buildTree(preorder, inorder)
}