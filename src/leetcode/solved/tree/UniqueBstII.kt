package leetcode.solved.tree

import java.util.*
import kotlin.collections.ArrayList

//95. Unique Binary Search Trees II
fun generateTrees(n: Int): List<TreeNode?> {
    return recTreeCreator(1, n)
}

fun recTreeCreator(start: Int, end: Int): ArrayList<TreeNode> {

    val list = ArrayList<TreeNode>()
    if (start == end) {
        list.add(TreeNode(start))
        return list
    }

    for (i in start..end) {
        var leftTrees: ArrayList<TreeNode>? = null
        var rightTrees: ArrayList<TreeNode>? = null

        if (i > start)
            leftTrees = recTreeCreator(start, i - 1)
        if (i < end)
            rightTrees = recTreeCreator(i + 1, end)

        if (leftTrees != null) {
            for (index in leftTrees.indices) {
                val daughterTreeHead = TreeNode(i)
                daughterTreeHead.left = leftTrees[index]
                leftTrees[index] = daughterTreeHead

                if (rightTrees != null) {
                    for (rightIndex in rightTrees.indices) {
                        val copiedLeftTree: TreeNode = if (rightIndex == rightTrees.lastIndex)
                            leftTrees[index] else treeCopy(leftTrees[index])

                        if (index == leftTrees.lastIndex)
                            copiedLeftTree.right = rightTrees[rightIndex]
                        else
                            copiedLeftTree.right = treeCopy(rightTrees[rightIndex])
                        list.add(copiedLeftTree)
                    }
                } else
                    list.add(leftTrees[index])
            }
        } else if(rightTrees!=null){
            for (index in rightTrees.indices){
                val daughterTreeHead = TreeNode(i)
                daughterTreeHead.right = rightTrees[index]
                list.add(daughterTreeHead)
            }
        }
    }

    return list

}
fun treeCopy(tree: TreeNode): TreeNode {
    val copyHead = TreeNode(tree.`val`)

    val stack = Stack<TreeNode>()
    val copyStack = Stack<TreeNode>()

    stack.push(tree)
    copyStack.push(copyHead)

    while (!stack.isEmpty()) {
        val node = stack.pop()
        val copyNode = copyStack.pop()

        if (node.left != null) {
            stack.push(node.left)
            copyNode.left = TreeNode(node.left!!.`val`)
            copyStack.push(copyNode.left)
        }
        if (node.right != null) {
            stack.push(node.right)
            copyNode.right = TreeNode(node.right!!.`val`)
            copyStack.push(copyNode.right)
        }
    }

    return copyHead
}

fun main(){
    val list = generateTrees(4)
}
