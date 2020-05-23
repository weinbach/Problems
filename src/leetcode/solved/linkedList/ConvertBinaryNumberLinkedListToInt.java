package leetcode.solved.linkedList;

public class ConvertBinaryNumberLinkedListToInt {
    //#1290 Convert Binary Number in a Linked List to Integer
    public int getDecimalValue(ListNode head) {
        if(head==null)
            return 0;
        ListNode reversed = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = reversed;
            reversed = head;
            head = temp;
        }
        int res = 0;
        int pow = 0;
        while(reversed!=null){
            res+=Math.pow(2,pow)*reversed.val;
            reversed=reversed.next;
            pow++;
        }
        return res;
    }
}
