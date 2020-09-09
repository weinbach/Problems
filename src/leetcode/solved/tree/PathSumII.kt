package leetcode.solved.tree

import kotlin.collections.ArrayList

//113. Path Sum II
fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
    if(root==null)
        return ArrayList<ArrayList<Int>>()
    val lists = findAllPaths(ArrayList(), root)
    val res = ArrayList<ArrayList<Int>>()
    for (list in lists){
        var count = 0
        for(value in list){
            count+=value
        }
        if(count==sum){
            res.add(list)
        }
    }
    return res
}

fun findAllPaths(array:ArrayList<Int>, root: TreeNode): ArrayList<ArrayList<Int>> {
    val list = ArrayList<ArrayList<Int>>()
    array.add(root.`val`)

    when{
        root.left==null && root.right==null -> {
            list.add(array)
            return list
        }
        root.left!=null && root.right!=null -> {
            val leftList = ArrayList<Int>()
            leftList.addAll(array)
            list.addAll(findAllPaths(leftList, root.left!!))
            list.addAll(findAllPaths(array, root.right!!))
        }
        root.left!=null -> {
            return findAllPaths(array, root.left!!)
        }
        root.right!=null -> {
            return findAllPaths(array, root.right!!)
        }
    }
    return list
}

fun main(){

    val head = TreeNode(5)
    val left = TreeNode(4)
    val right = TreeNode(8)

    head.left = left
    head.right = right

    val lleft = TreeNode(11)
    val rleft = TreeNode(13)
    val rright = TreeNode(4)

    left.left = lleft
    right.left = rleft
    right.right = rright

    val llLeft = TreeNode(7)
    val llRight = TreeNode(2)
    val rrLeft = TreeNode(5)
    val rrRight = TreeNode(1)

    lleft.left = llLeft
    lleft.right = llRight
    rright.left = rrLeft
    rright.right =rrRight

    pathSum(head, 22)

}