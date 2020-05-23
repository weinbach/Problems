package leetcode.solved.linkedList;

public class ReverseLinkedListTwo {
    //#92 Reverse Linked List II
    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ListNode lnCopy = ln;
        for (int i = 2; i <= 9; i++) {
            lnCopy.next = new ListNode(i);
            lnCopy = lnCopy.next;
        }

        ListNode res = reverseBetween(ln, 1, 5);
        while (res != null) {
            System.out.print(" -> " + res.val);
            res = res.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null||m==n)
            return head;

        ListNode ln = m==1? head : head.next;
        ListNode startReverse = head;
        ListNode endReverse = head.next;
        ListNode reversed = null;

        int counter = 0;
        while (ln!=null && counter<n){
            if(m==1){
                startReverse = head;
                endReverse = head;
            }
            else if (counter<(m-2)){
                if(startReverse.next==null)
                    return head;
                startReverse = startReverse.next;
                endReverse = startReverse.next;
                ln=startReverse.next;
            }
            if(counter>(m-2)){
                ListNode temp = ln.next;
                ln.next = reversed;
                reversed = ln;
                ln = temp;
            }
            counter++;
        }
        if(m!=1)
            startReverse.next = reversed;
        else
            head = reversed;
        endReverse.next = ln;
        return head;
    }

}
