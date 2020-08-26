package leetcode.solved.tree

import kotlin.collections.ArrayList

//894. All Possible Full Binary Trees
fun allPossibleFBT(n: Int): ArrayList<TreeNode> {
    val list = ArrayList<TreeNode>()
    when {
        n % 2 == 0 -> return list
        n == 1 -> {
            list.add(TreeNode(0))
            return list
        }
    }

    var leftNodes = 1
    var rightNodes = n - 2

    while (leftNodes <= n - 2) {
        val leftTrees: ArrayList<TreeNode> = allPossibleFBT(leftNodes)
        val rightTrees: ArrayList<TreeNode> = allPossibleFBT(rightNodes)

        for (leftIndex in leftTrees.indices) {
            val node = TreeNode(0)
            node.left = leftTrees[leftIndex]
            leftTrees[leftIndex] = node

            for (rightIndex in rightTrees.indices) {
                val copiedLeftTree = if (rightIndex == rightTrees.lastIndex)
                    leftTrees[leftIndex] else treeCopy(leftTrees[leftIndex])

                if (leftIndex == leftTrees.lastIndex)
                    copiedLeftTree.right = rightTrees[rightIndex]
                else
                    copiedLeftTree.right = treeCopy(rightTrees[rightIndex])
                list.add(copiedLeftTree)
            }
        }

        rightNodes -= 2
        leftNodes += 2
    }
    return list
}


