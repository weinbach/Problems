class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var res: ListNode? = null
    var iterator: ListNode? = res
    var carry = 0

    var node1 = l1
    var node2 = l2

    while (node1!=null || node2!=null){
        val sum: Int = (node1?.`val`?:0) + (node2?.`val`?:0) + carry
        carry = sum/10

        if(res == null){
            res = ListNode(sum%10)
            iterator = res
        } else{
            iterator?.next = ListNode(sum%10)
            iterator = iterator?.next
        }

        node1 = node1?.next
        node2 = node2?.next
    }

    if(carry>0)
        iterator?.next = ListNode(carry)

    return res
}

fun main(){

    var l1 = ListNode(2)
    var l2 = ListNode(4)
    var l3 = ListNode(3)

    l1.next = l2
    l2.next = l3

    var ll1 = ListNode(5)
    var ll2 = ListNode(6)
    var ll3 = ListNode(4)

    ll1.next = ll2
    ll2.next = ll3

    var asd: ListNode? = addTwoNumbers(l1, ll1)

    while (asd!=null){
        print(" ${asd.`val`}")
        asd = asd.next
    }
}