package leetcode.solved.linkedList;

public class RemoveDuplicatesFromSortedList {
    //#83 Remove Duplicates from Sorted List

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ListNode lnCopy = ln;
        for (int i = 2; i <= 6; i++) {
            lnCopy.next = new ListNode(1);
            lnCopy = lnCopy.next;
        }
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);

        ListNode res = deleteDuplicates(ln);
        while (res != null) {
            System.out.print(" -> " + res.val);
            res = res.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode currNode = head;
        ListNode nextNode = head.next;
        while(true){
            while(nextNode!=null){
                if(currNode.val==nextNode.val)
                    nextNode=nextNode.next;
                else
                    break;
            }

            currNode.next = nextNode;

            if(currNode.next==null || currNode.next.next==null)
                break;
            currNode = currNode.next;
            nextNode = currNode.next;

        }
        return head;
    }
}
