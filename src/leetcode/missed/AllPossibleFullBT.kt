package leetcode.missed

import leetcode.solved.tree.TreeNode
import java.util.*

//894. All Possible Full Binary Trees
fun allPossibleFBT(N: Int): List<TreeNode?> {
    val node = TreeNode(0)
    return test(node, N - 1, node, false, 0, null)
}

class CopyTree() {
    lateinit var currForkNode: TreeNode
    lateinit var treeHead: TreeNode
    var secondSideDeepNode: TreeNode? = null
}

fun copyTree(head: TreeNode?, currNode: TreeNode, secondSideDeepNode: TreeNode?): CopyTree {
    val copyHead = TreeNode(0)

    val stack = Stack<TreeNode>()
    val copyStack = Stack<TreeNode>()

    stack.push(head)
    copyStack.push(copyHead)

    val newTree = CopyTree()
    newTree.treeHead = copyHead

    while (!stack.isEmpty()) {
        val node = stack.pop()
        val copyNode = copyStack.pop()

        if (node.left != null) {
            stack.push(node.left)
            copyNode.left = TreeNode(0)
            copyStack.push(copyNode.left)
        }
        if (node.right != null) {
            stack.push(node.right)
            copyNode.right = TreeNode(0)
            copyStack.push(copyNode.right)
        }

        if (node == currNode) {
            newTree.currForkNode = copyNode
        }
        if(secondSideDeepNode!=null && node == secondSideDeepNode){
            newTree.secondSideDeepNode = copyNode
        }
    }

    return newTree
}

fun test(tree: TreeNode?, N: Int, currNode: TreeNode, bothSides: Boolean, secondSideNodes: Int, secondSideDeepNode: TreeNode?): List<TreeNode?> {
    val list = Stack<TreeNode>()
    if(N%2!=0)
        return list
    if (N==0){
        list.push(tree)
        return list
    }

    currNode.left = TreeNode(0)
    currNode.right = TreeNode(0)

    return if (N == 2) {
        if(bothSides){
            list.addAll(test(tree, secondSideNodes, secondSideDeepNode!!, false, 0, null))
        } else
            list.add(tree)
        list
    } else {
        var leftNodes = 0
        var rightNodes = N - 2
        while (leftNodes <= N - 2) {
            val newTree = copyTree(tree, currNode, secondSideDeepNode)
            if (leftNodes > 0 && rightNodes>0) {
                val newList = Stack<TreeNode>()
                newList.addAll(test(newTree.treeHead, leftNodes, newTree.currForkNode.left!!, true, rightNodes, newTree.currForkNode.right))
                if(bothSides){
                    for(leftTree in newList)
                        list.addAll(test(leftTree, secondSideNodes, newTree.secondSideDeepNode!!, false, 0, null))
                }
                else
                    list.addAll(newList)
            } else {
                if (leftNodes > 0) {
                    list.addAll(test(newTree.treeHead, leftNodes, newTree.currForkNode.left!!, bothSides, secondSideNodes, newTree.secondSideDeepNode))
                }
                if (rightNodes > 0) {
                    list.addAll(test(newTree.treeHead, rightNodes, newTree.currForkNode.right!!, bothSides, secondSideNodes, newTree.secondSideDeepNode))
                }
            }

            rightNodes -= 2
            leftNodes += 2
        }
        list
    }
}

fun main() {
    val list = allPossibleFBT(13)
    val a = 2

}
