package leetcode.solved.linkedList;

public class OddEvenLinkedList {
    //#328 Odd Even Linked List
    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ListNode lnCopy = ln;
        for (int i = 2; i <= 5; i++) {
            lnCopy.next = new ListNode(i);
            lnCopy = lnCopy.next;
        }

        ListNode res = oddEvenList(ln);
        while (res != null) {
            System.out.print(" -> " + res.val);
            res = res.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)
            return head;

        ListNode odd = new ListNode(0);
        ListNode oddIterative = odd;
        ListNode even = new ListNode(0);
        ListNode evenIterative = even;

        boolean isOdd = true;
        while(head!=null){

            if(isOdd){
                oddIterative.next = head;
                oddIterative = oddIterative.next;
                isOdd = false;
            } else{
                evenIterative.next = head;
                evenIterative = evenIterative.next;
                isOdd = true;
            }

            head = head.next;
        }
        evenIterative.next = null;
        oddIterative.next = even.next;

        return odd.next;
    }
}
