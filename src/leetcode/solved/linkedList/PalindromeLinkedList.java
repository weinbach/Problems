package leetcode.solved.linkedList;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(2);
        ln.next.next.next = new ListNode(1);
        System.out.println("res: " + isPalindrome(ln));
    }

    public static boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;

        ListNode iterative = head;
        ListNode reversed = null;
        int count = 0;

        while(iterative!=null){
            count++;
            iterative=iterative.next;
        }
        iterative = head;
        count = count%2==0? count/2: count/2+1;
        for(int i=0;i<count;i++){
            iterative = iterative.next;
        }

        while(iterative!=null){
            ListNode temp = iterative.next;
            iterative.next = reversed;
            reversed = iterative;
            iterative = temp;
        }

        iterative = head;

        while(reversed!=null){
            if(reversed.val!=iterative.val)
                return false;
            reversed=reversed.next;
            iterative=iterative.next;
        }

        return true;
    }

}
