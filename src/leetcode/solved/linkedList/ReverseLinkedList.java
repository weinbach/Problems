package leetcode.solved.linkedList;

public class ReverseLinkedList {
    //#206 Reverse Linked List
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode reversed = null;
        while (head!=null){
            ListNode temp = head.next;
            head.next = reversed;
            reversed = head;
            head = temp;
        }
        return reversed;
    }
}
