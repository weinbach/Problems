package leetcode.solved.linkedList

//23. Merge k Sorted Lists

//Runtime: 392 ms, faster than 30.56%
//Memory Usage: 39 MB, less than 48.61%
fun mergeKLists(lists: Array<ListNode?>): ListNode? {

    val arr: ArrayList<ListNode?> = ArrayList()
    for(list in lists){
        if (list!=null)
            arr.add(list)
    }

    val mergedHead = ListNode(-1)
    var tempNode = mergedHead

    while (arr.isNotEmpty()){

        var minVal = Int.MAX_VALUE
        var minIndex = 0
        for(i in 0 until arr.size){
            if (arr[i]!!.`val`<=minVal){
                minVal = arr[i]!!.`val`
                minIndex = i
            }
        }

        tempNode.next = arr[minIndex]
        tempNode = tempNode.next

        arr[minIndex] = arr[minIndex]!!.next
        if (arr[minIndex] == null){
            arr.removeAt(minIndex)
        }

    }

    return mergedHead.next
}

