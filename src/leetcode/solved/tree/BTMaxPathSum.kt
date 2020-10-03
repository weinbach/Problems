package leetcode.solved.tree

//124. Binary Tree Maximum Path Sum

//Runtime: 216 ms, faster than 65.06%
//Memory Usage: 39.6 MB, less than 24.10%
var res: Int = Int.MIN_VALUE

fun maxPathSum(root: TreeNode?): Int {
    maxPath(root)
    return res
}

fun maxPath(root: TreeNode?): Int {
    if (root == null)
        return 0

    val leftMax = maxPath(root.left)
    val rightMax = maxPath(root.right)

    val currMax: Int
    currMax = when{
        leftMax > 0 && rightMax > 0 -> {
            if(root.`val` + leftMax + rightMax > res)
                res  = root.`val` + leftMax + rightMax
            root.`val` + Math.max(leftMax, rightMax)
        }
        leftMax > 0 ->
            root.`val`  + leftMax

        rightMax > 0 ->
            root.`val` + rightMax

        else ->
            root.`val`
    }

    if(currMax>res)
        res =  currMax

    return currMax
}
