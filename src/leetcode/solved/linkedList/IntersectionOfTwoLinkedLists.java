package leetcode.solved.linkedList;

public class IntersectionOfTwoLinkedLists {
    //#160 Intersection of Two Linked Lists
    public static void main(String[] args) {

        ListNode intersect = new ListNode(8);

        ListNode one = new ListNode(4);
        one.next = new ListNode(1);
        one.next.next = intersect;
        one.next.next.next = new ListNode(4);
        one.next.next.next.next = new ListNode(5);

        ListNode two = new ListNode(5);
        two.next = new ListNode(0);
        two.next.next= new ListNode(1);
        two.next.next.next = intersect;

        getIntersectionNode(one,two);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        ListNode aIterator = headA;
        ListNode bIterator = headB;
        int aSize = 0;
        int bSize = 0;

        while(aIterator!=null){
            aSize++;
            aIterator=aIterator.next;
        }
        while(bIterator!=null){
            bSize++;
            bIterator=bIterator.next;
        }

        int diff;
        if(aSize>bSize){
            diff = aSize -bSize;
            while(diff>0){
                headA = headA.next;
                diff--;
            }
        } else if(aSize!=bSize){
            diff = bSize-aSize;
            while(diff>0){
                headB=headB.next;
                diff--;
            }
        }
        while(headA!=null){
            if(headA.equals(headB))
                return headA;
            headA=headA.next;
            headB=headB.next;
        }

        return null;
    }

}
