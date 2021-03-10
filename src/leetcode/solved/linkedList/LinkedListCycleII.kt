package leetcode.solved.linkedList

// 142. Linked List Cycle II
// Runtime: 100 ms, faster than 84.88%
// Memory Usage: 34.2 MB, less than 73.26%
fun detectCycle(head: ListNode?): ListNode? {
    if(head == null)
        return null
    var p1 = 0
    var p2 = 0
    var node1 = head
    var node2 = head

    while(node2!=null){
        p1++
        p2++
        if(node2.next == null || node2.next.next ==null)
            return null
        node2 = node2.next.next
        node1 = node1!!.next

        if(node1 == node2)
            break
    }

    node1 = head

    while(node1!=node2){
        node1 = node1!!.next
        node2 = node2!!.next
    }

    return node1

}