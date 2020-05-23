package leetcode.solved.linkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class RemoveNodeFromEnd {
    //#19 Remove Nth Node From End of List
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        while(n>-1){
            if(second==null)
                return head.next;
            second=second.next;
            n--;
        }
        while(second!=null){
            second=second.next;
            first=first.next;
        }
        first.next=first.next.next;
        return head;
    }

}
