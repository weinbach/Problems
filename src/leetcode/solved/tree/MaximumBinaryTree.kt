package leetcode.solved.tree

import java.util.*

//654. Maximum Binary Tree
fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
    if(nums.size==1)
        return TreeNode(nums[0])

    val maxNum = nums.maxOrNull()!!
    val maxNumIndex = nums.indexOf(maxNum)
    val node = TreeNode(maxNum)

    if(maxNumIndex>0)
        node.left = constructMaximumBinaryTree(nums.sliceArray(0 until maxNumIndex))
    if(maxNumIndex<nums.size-1)
        node.right = constructMaximumBinaryTree(nums.sliceArray(maxNumIndex+1 until nums.size))

    return node
}


fun main(){

    val nums = arrayOf(1, 2, 3, 4, 5)
    val slice = nums.sliceArray(1..3)
    println(Arrays.toString(slice)) // prints [2, 3, 4]
    println(Arrays.toString(nums)) // prints [2, 3, 4]

}

