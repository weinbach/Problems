package leetcode.solved.tree

import java.util.*

//1315. Sum of Nodes with Even-Valued Grandparent
class TreeNodeKt(var `val`: Int) {
    var left: TreeNodeKt? = null
    var right: TreeNodeKt? = null
}

fun sumEvenGrandparent(root: TreeNodeKt?): Int {
    val queue = LinkedList<TreeNodeKt>()
    if (root == null)
        return 0;

    var sum = 0
    queue.push(root)

    while (!queue.isEmpty()) {
        val node: TreeNodeKt = queue.pop()
        if (node.`val` % 2 == 0) {
            if(node.left!=null){
                queue.push(node.left)
                if(node.left!!.left!=null)
                    sum+= node.left!!.left!!.`val`
                if(node.left!!.right!=null)
                    sum+=node.left!!.right!!.`val`
            }
            if(node.right!=null){
                queue.push(node.right)
                if(node.right!!.left!=null)
                    sum+=node.right!!.left!!.`val`
                if(node.right!!.right!=null)
                    sum+=node.right!!.right!!.`val`
            }
        } else{
            if(node.left!=null)
                queue.push(node.left)
            if(node.right!=null)
                queue.push(node.right)
        }
    }

    return sum
}

fun main(){
    val node = TreeNodeKt(61)
    node.left = TreeNodeKt(13)
    node.right = TreeNodeKt(46)
    node.right!!.right = TreeNodeKt(56)
    node.right!!.right!!.left = TreeNodeKt(72)

    print(sumEvenGrandparent(node))
}