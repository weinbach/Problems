package leetcode.solved.linkedList;

public class SwapNodesInPairs {
    //#24 Swap Nodes in Paris
    public static void main(String[] args) {
        ListNode ln = new ListNode(2);
        ln.next = new ListNode(1);
        ln.next.next = new ListNode(7);
        ln.next.next.next = new ListNode(9);

        ListNode res = swapPairs(ln);
        while (res != null) {
            System.out.print(" -> " + res.val);
            res = res.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode ln = head;
        ListNode lastIn1stPair = ln.next;
        ln.next = ln.next.next;
        lastIn1stPair.next = ln;
        head = lastIn1stPair;

        while (ln.next != null && ln.next.next != null) {
            ListNode lastInPair = ln.next.next;
            ln.next.next = ln.next.next.next;
            lastInPair.next = ln.next;
            ln.next = lastInPair;
            ln = ln.next.next;
        }

        return head;
    }
}
