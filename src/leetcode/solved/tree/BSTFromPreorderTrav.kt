package leetcode.solved.tree

//1008. Construct Binary Search Tree from Preorder Traversal
fun bstFromPreorder(preorder: IntArray): TreeNode? {
    if(preorder.isEmpty()) return null
    if(preorder.size==1) return TreeNode(preorder[0])
    val node = TreeNode(preorder[0])

    var firstGreaterValIndex = 0
    for (i in 1 until preorder.size) {
        if(preorder[i]>preorder[0]){
            firstGreaterValIndex = i
            break
        }
    }

    node.left = bstFromPreorder(preorder.sliceArray(1 until if(firstGreaterValIndex>0)firstGreaterValIndex else preorder.size))
    if(firstGreaterValIndex>0)
        node.right = bstFromPreorder(preorder.sliceArray(firstGreaterValIndex until preorder.size))

    return node
}

fun main(){
    bstFromPreorder(intArrayOf(8,5,1,7,10,12))
}