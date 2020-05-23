package leetcode.solved.linkedList;

public class MergeTwoSoredLists {
    //#21 Merge Two Sorted Lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                temp.next = l2;
                l2 = l2.next;
            } else{
                temp.next=l1;
                l1 = l1.next;
            }
            temp=temp.next;
        }
        if(l2!=null)
            temp.next = l2;
        else if(l1!=null)
            temp.next = l1;

        return res.next;
    }

}
