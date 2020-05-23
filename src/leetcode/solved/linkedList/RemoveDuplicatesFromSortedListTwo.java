package leetcode.solved.linkedList;

public class RemoveDuplicatesFromSortedListTwo {
    //#82 Remove Duplicates from Sorted List II

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode preCurr = null;
        ListNode currNode = head;
        ListNode nextNode = head.next;
        while (true) {

            if(nextNode==null)
                return head;

            if (currNode.val == nextNode.val) {
                nextNode = nextNode.next;
                while (nextNode != null) {
                    if(currNode.val == nextNode.val){
                        nextNode = nextNode.next;
                    } else{
                        break;
                    }
                }
                if(preCurr==null){
                    head=nextNode;
                    currNode=head;
                }
                else{
                    preCurr.next = nextNode;
                    currNode=preCurr.next;
                }

                if(currNode==null)
                    return head;
                nextNode = currNode.next;
            } else{
                preCurr=currNode;
                currNode = currNode.next;
                nextNode = nextNode.next;
            }
        }
    }

}
