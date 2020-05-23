package leetcode.solved.linkedList;

public class RemoveLinkedListElement {
    //#203 Remove Linked List Element
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return null;

        ListNode curr = head;
        ListNode pre = null;
        while(curr!=null){

            if(curr.val==val){
                if(pre!=null){
                    pre.next = curr.next;
                    curr=pre.next;
                } else{
                    head = head.next;
                    curr = head;
                }
                continue;
            }

            pre=curr;
            curr=curr.next;
        }
        return head;
    }
}
