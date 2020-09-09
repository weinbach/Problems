package leetcode.solved.tree

//129. Sum Root to Leaf Numbers

//Runtime: 144 ms, faster than 92.59%
//Memory Usage: 32.5 MB, less than 85.19%

fun sumNumbers(root: TreeNode?): Int {
    return sum(0, root)
}

fun sum(num: Int, root: TreeNode?): Int {
    if (root == null) return 0
    val count = num * 10 + root.`val`
    if(root.left == null && root.right == null)
        return count
    return sum(count, root.left) + sum(count, root.right)
}
