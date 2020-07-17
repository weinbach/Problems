package leetcode.solved.tree

//701. Insert into a Binary Search Tree
fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null) return TreeNode(`val`)
    var node = root

    while (node!=null) {
        if (node.`val` > `val`) {
            if (node.left != null)
                node = node.left
            else{
                node.left = TreeNode(`val`)
                break
            }
        } else{
            if(node.right!=null)
                node = node.right
            else{
                node.right = TreeNode(`val`)
                break
            }
        }
    }

    return root
}