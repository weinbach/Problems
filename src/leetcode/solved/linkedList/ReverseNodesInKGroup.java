package leetcode.solved.linkedList;

public class ReverseNodesInKGroup {
    //#25 Reverse Nodes in k-Group

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ListNode lnCopy = ln;
        for (int i = 2; i <= 6; i++) {
            lnCopy.next = new ListNode(i);
            lnCopy = lnCopy.next;
        }

        ListNode res = reverseKGroup(ln, 4);
        while (res != null) {
            System.out.print(" -> " + res.val);
            res = res.next;
        }
    }

    public static ListNode reverseKGroupWrong(ListNode head, int k) {
        // reverse like : 1 2 3 4 5 6 7 8 9; k=4 -> 4 2 3 1 8 6 7 5 9
        if (head == null)
            return head;

        ListNode start = head;
        ListNode end = head;

        for (int i = 0; i < k - 2; i++) {
            if (end == null)
                return head;
            end = end.next;
        }
        if (end.next == null)
            return head;

        ListNode faPlus = start.next;
        ListNode fn = end.next;

        start.next = fn.next;
        end.next = start;
        fn.next = faPlus;
        head = fn;

        while (true) {
            for (int i = 0; i < k; i++) {
                if (end.next == null || end.next.next == null)
                    return head;
                end = end.next;
            }
            if (end.next == null)
                return head;

            ListNode aPlus = start.next.next;
            ListNode n = end.next;

            start.next.next = end.next.next; //  a->n+1
            end.next = start.next;
            start.next = n;
            n.next = aPlus;

            start = end.next;
        }

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        ListNode end = head;
        ListNode lnRes = null;
        ListNode ln = head;
        boolean first = true;
        while (true) {
            boolean enoughToReverse = true;
            for (int i = 1; i < k; i++) {
                if (end == null || end.next == null) {
                    enoughToReverse = false;
                    break;
                }
                end = end.next;
            }
            if (!enoughToReverse) {
                if (!first) {
                    head.next = ln;
                    return lnRes;
                } else
                    return head;
            } else {
                ListNode firstNode = ln;
                ListNode lnReversed = null;
                for (int i = 0; i < k; i++) {
                    ListNode temp = ln.next;
                    ln.next = lnReversed;
                    lnReversed = ln;
                    ln = temp;
                }
                if (first) {
                    lnRes = lnReversed;
                    first = false;
                } else {
                    head.next = lnReversed;
                    head = firstNode;
                }
                end = ln;
            }
        }
    }

}
