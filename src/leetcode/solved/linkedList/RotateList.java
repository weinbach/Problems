package leetcode.solved.linkedList;

public class RotateList {
    //#61 Rotate List

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ListNode lnCopy = ln;
        for (int i = 2; i <= 3; i++) {
            lnCopy.next = new ListNode(i);
            lnCopy = lnCopy.next;
        }

        ListNode res = rotateRight(ln, 4);
        while (res != null) {
            System.out.print(" -> " + res.val);
            res = res.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int size = 1;
        ListNode end = head;
        ListNode edge = head;

        int i = k;
        while (i > 0 && end.next != null) {
            end = end.next;
            i--;
            size++;
        }
        while (end != null && end.next!=null) {
            end = end.next;
            edge = edge.next;
            size++;
            if (end.next == null)
                break;
        }

        if(k<size){
            end.next = head;
            head = edge.next;
            edge.next = null;
        } else {
            k = k%size;
            if(k==0)
                return head;
            return rotateRight(head, k);
        }
        return head;
    }

}
