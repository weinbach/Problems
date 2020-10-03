package leetcode.solved.tree

//108. Convert Sorted Array to Binary Search Tree

//Runtime: 176 ms, faster than 97.66%
//Memory Usage: 37 MB, less than 60.82%
fun sortedArrayToBST(nums: IntArray): TreeNode? {
    return constructTree(nums, 0, nums.size-1)
}

fun constructTree(nums: IntArray, left: Int, right: Int): TreeNode?{
    if(left>right)
        return null
    if(left == right)
        return TreeNode(nums[left])

    val middle = (left+right)/2
    val head = TreeNode(nums[middle])
    head.left = constructTree(nums, left, middle-1)
    head.right = constructTree(nums, middle+1, right)
    return head
}