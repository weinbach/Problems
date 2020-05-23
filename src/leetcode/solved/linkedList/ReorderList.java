package leetcode.solved.linkedList;

public class ReorderList {
    //#143 Reorder List

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ListNode lnCopy = ln;
        for (int i = 2; i <= 3; i++) {
            lnCopy.next = new ListNode(i);
            lnCopy = lnCopy.next;
        }

        ListNode res = null;
                reorderList(ln);
        while (ln != null) {
            System.out.print(" -> " + ln.val);
            ln = ln.next;
        }
    }
    public static void reorderList(ListNode head) {

        if(head==null||head.next==null)
            return;

        ListNode ln = head;
        ListNode middleElement = null;
        int count = 0;

        while (ln!=null){
            ln=ln.next;
            count++;
        }
        ln = head;

        for(int i=0;i<count/2;i++){
            ln = ln.next;
        }

        if(count%2!=0){
            middleElement = new ListNode(ln.val);
            ln=ln.next;
        }

        ListNode reversed = null;
        while(ln!=null){
            ListNode temp = ln.next;
            ln.next = reversed;
            reversed = ln;
            ln = temp;
        }

        ln = head;
        ListNode res = new ListNode(0);

        for(int i=0;i<count/2;i++){
            ListNode temp = ln.next;
            res.next = ln;
            res.next.next = reversed;
            ln = temp;
            reversed = reversed.next;
            res=res.next.next;
        }

        res.next = middleElement;

    }
}
