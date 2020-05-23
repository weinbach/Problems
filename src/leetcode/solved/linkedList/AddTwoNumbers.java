package leetcode.solved.linkedList;

public class AddTwoNumbers {
    //#2 Add Two Numbers
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l1.next = new ListNode(7);
        l2.next = new ListNode(2);


        ListNode asd = addTwoNumbers(l1, l2);

        while(asd!=null){
            System.out.print("->" + asd.val);
            asd = asd.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode(0);
        ListNode iterative = resultList;

        int carry = 0;
        while (l1!=null && l2!=null){
            int x = (l1.val + l2.val + carry)%10;
            carry = (l1.val+l2.val+carry)/10;
            iterative.next = new ListNode(x);
            iterative = iterative.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode rest = l1!=null ? l1 : l2;
        if(rest!=null || carry>0){
            while (carry>0 && rest!=null){
                int x = (rest.val + carry)%10;
                carry = (rest.val+carry)/10;
                rest = rest.next;
                iterative.next = new ListNode(x);
                iterative = iterative.next;
            }
            if(rest!=null)
                iterative.next = rest;
            else if(carry>0)
                iterative.next = new ListNode(carry);
        }
        resultList = resultList.next;

        return resultList;
    }

}
