package leetcode.solved.tree

import java.util.*

//1305. All Elements in Two Binary Search Trees
fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {

    val list1 = inOrderTraverse(root1)
    val list2 = inOrderTraverse(root2)
    val elements = Stack<Int>()

    while (!list1.isEmpty() || !list2.isEmpty()){
        if(list1.isEmpty()){
            elements.addAll(list2)
            break
        }
        else if(list2.isEmpty()){
            elements.addAll(list1)
            break
        }

        elements.push(if(list1.peek()<list2.peek()) list1.poll() else list2.poll())
    }

    return elements
}

fun inOrderTraverse(root: TreeNode?): Queue<Int>{
    var curr: TreeNode? = root
    val stack: Stack<TreeNode> = Stack()

    val quque: Queue<Int> = LinkedList()

    while (curr!=null || !stack.isEmpty()){
        while (curr!=null){
            stack.push(curr)
            curr = curr.left
        }

        curr = stack.pop()
        quque.add(curr.`val`)
        curr = curr.right
    }

    return quque
}

fun main(){
    val node = TreeNode(2)
    node.left = TreeNode(1)
    node.right = TreeNode(4)

    val node1 = TreeNode(1)
    node1.left = TreeNode(0)
    node1.right = TreeNode(3)

    getAllElements(node, node1)
}