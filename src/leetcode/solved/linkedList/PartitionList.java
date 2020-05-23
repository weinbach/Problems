package leetcode.solved.linkedList;

public class PartitionList {
    //#86 Partition List

    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next == null)
            return head;
        ListNode lower = new ListNode(0);
        ListNode higher = new ListNode(0);
        ListNode iterateLow = lower;
        ListNode iterateHigh = higher;

        while(head!=null){
            if(head.val>=x){
                iterateHigh.next = head;
                iterateHigh = iterateHigh.next;
            } else{
                iterateLow.next = head;
                iterateLow = iterateLow.next;
            }
            head=head.next;
        }
        iterateHigh.next=null;
        iterateLow.next = higher.next;
        return lower.next;
    }
}
