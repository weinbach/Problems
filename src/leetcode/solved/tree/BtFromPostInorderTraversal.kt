package leetcode.solved.tree

//106. Construct Binary Tree from Inorder and Postorder Traversal
private fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    return buildTreee(inorder, postorder, null)
}

fun buildTreee(inorder: IntArray, postorder: IntArray, daughterNode: TreeNode?): TreeNode? {
    if (inorder.isEmpty())
        return null
    if (inorder.size==1){
        val resNode = TreeNode(inorder[0])
        if(daughterNode!=null)
            resNode.left = daughterNode
        return resNode
    }

    val node = TreeNode(inorder[0])
    if(daughterNode!=null)
        node.left = daughterNode
    val index = postorder.indexOf(inorder[0])

    if (index>0)
        node.right = buildTreee(inorder.copyOfRange(1, index+1), postorder.copyOfRange(0, index), null)

    return if(index<postorder.size-1) {
        buildTreee(inorder.copyOfRange(index + 1, inorder.lastIndex+1), postorder.copyOfRange(index + 1, inorder.lastIndex+1), node)
    } else
        node
}

fun main(){
    val inorder = intArrayOf(3,2,1)
    val postorder = intArrayOf(3,2,1)

    buildTree(inorder, postorder)
}