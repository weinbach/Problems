import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BSTIterator(private var current: TreeNode?) {

    var stack: Stack<TreeNode> = Stack()

    fun next(): Int {
        while (current!=null){
            stack.push(current)
            current = current!!.left
        }

        current = stack.pop()
        val value: Int = current!!.`val`
        current = current!!.right
        return value
    }

    fun hasNext(): Boolean {
        return !stack.empty() || current!=null
    }

}