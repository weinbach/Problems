package leetcode.solved.linkedList

// 138. Copy List with Random Pointer
// Runtime: 184 ms, faster than 43.92%
// Memory Usage: 35.6 MB, less than 82.75%
internal class Node(`val`: Int) {
    var `val`: Int
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
    var random: Node? = null

    init {
        this.`val` = `val`
    }
}
private fun copyRandomList(node: Node?): Node? {
    if (node == null)
        return null

    val mapOne = HashMap<Node, Int>()
    val mapTwo = ArrayList<Node>()
    var mapOneIndex = 0

    var initialNode: Node? = node
    val copiedNode = Node(0)
    var iterationNode = copiedNode

    while (initialNode != null) {

        if (mapOne.contains(initialNode)) {
            iterationNode.next = mapTwo[mapOne[initialNode]!!]
        } else {
            mapOne[initialNode] = mapOneIndex++
            val currNodeCopy = Node(initialNode.`val`)

            iterationNode.next = currNodeCopy
            mapTwo.add(currNodeCopy)
        }
        iterationNode = iterationNode.next!!
        if (initialNode.random != null) {
            if (mapOne.contains(initialNode.random)) {
                iterationNode.random = mapTwo[mapOne[initialNode.random!!]!!]
            } else {
                val newRandomNode = Node(initialNode.random!!.`val`)
                iterationNode.random = newRandomNode
                mapOne[initialNode.random!!] = mapOneIndex++
                mapTwo.add(newRandomNode)
            }
        }
        initialNode = initialNode.next

    }

    return copiedNode.next
}