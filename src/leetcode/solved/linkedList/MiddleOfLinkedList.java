package leetcode.solved.linkedList;

public class MiddleOfLinkedList {
    //#876 Middle of the Linked List
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null)
            return head;
        int count = 0;
        ListNode ln = head;
        while(ln!=null){
            ln=ln.next;
            count++;
        }

        count = count/2;
        for(int i=0;i<count;i++){
            head=head.next;
        }
        return head;
    }
}
