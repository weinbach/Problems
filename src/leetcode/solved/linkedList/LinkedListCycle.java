package leetcode.solved.linkedList;

public class LinkedListCycle {
    //#141 Linked List Cycle
    public static void main(String[] args) {
        ListNode ln = new ListNode(3);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(0);
        ln.next.next.next = new ListNode(-4);
        ln.next.next.next.next=ln.next;
        System.out.println("res: " + hasCycle(ln));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode ln = head;
        while(ln!=null && ln.next!=null){
            ln = ln.next.next;
            head = head.next;
            if(head.equals(ln))
                return true;
        }

        return false;
    }

}
