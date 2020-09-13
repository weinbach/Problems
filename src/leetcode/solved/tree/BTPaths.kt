package leetcode.solved.tree

//257. Binary Tree Paths
fun binaryTreePaths(root: TreeNode?): List<String> {
    if (root == null)
        return ArrayList<String>()
    return paths("", root)
}

fun paths(path: String, root: TreeNode): List<String> {

    val listOfPaths = ArrayList<String>()
    val newPath = if(path.isNotEmpty()) "$path->${root.`val`}" else root.`val`.toString()

    if (root.left == null && root.right == null) {
        listOfPaths.add(newPath)
        return listOfPaths
    }
    if (root.left != null)
        listOfPaths.addAll(paths(newPath, root.left!!))
    if (root.right != null)
        listOfPaths.addAll(paths(newPath, root.right!!))

    return listOfPaths
}