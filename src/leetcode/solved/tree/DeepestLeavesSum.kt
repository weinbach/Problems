package leetcode.solved.tree

import java.util.*
//1302. Deepest Leaves Sum
fun deepestLeavesSum(root: TreeNode?): Int {
    var sum = 0
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)

    var currLvlNodes = 1
    var nextLvlNodes = 0
    var currNodeIndex = 0

    while (!queue.isEmpty()) {
        val node = queue.poll()
        currNodeIndex++
        sum+=node.`val`

        if (node.left != null) {
            queue.add(node.left)
            nextLvlNodes++
        }
        if (node.right != null) {
            queue.add(node.right)
            nextLvlNodes++
        }

        if(currNodeIndex==currLvlNodes){
            if(nextLvlNodes==0)
                return sum
            currLvlNodes = nextLvlNodes
            nextLvlNodes = 0
            currNodeIndex = 0
            sum = 0
        }

    }
    return sum
}

fun main(){

    val node = TreeNode(1)
    node.left = TreeNode(2)
    node.right = TreeNode(3)

    node.left!!.left = TreeNode(4)
    node.left!!.right = TreeNode(5)
    node.left!!.left!!.left = TreeNode(7)

    node.right!!.right = TreeNode(6)
    node.right!!.right!!.right = TreeNode(8)

    print(deepestLeavesSum(node))

}