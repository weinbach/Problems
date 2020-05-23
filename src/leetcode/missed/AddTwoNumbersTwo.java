package leetcode.missed;

class ListNode{
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbersTwo {
    //#445 Add Two Numbers II

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ListNode lnCopy = ln;
        for (int i = 2; i <= 4; i++) {
            lnCopy.next = new ListNode(i);
            lnCopy = lnCopy.next;
        }

        ListNode lnn = new ListNode(3);
        lnCopy = lnn;
        for (int i = 4; i <= 5; i++) {
            lnCopy.next = new ListNode(i);
            lnCopy = lnCopy.next;
        }

        ListNode res = addTwoNumbers(new ListNode(5), new ListNode(2));
        while (res != null) {
            System.out.print(" -> " + res.val);
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
            return new ListNode(0);
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;

        long numOne = 0;
        long numTwo = 0;

        while(l1!=null){
            numOne = numOne*10;
            numOne+=l1.val;
            l1=l1.next;
        }
        while(l2!=null){
            numTwo=numTwo*10;
            numTwo+=l2.val;
            l2=l2.next;
        }
        long sum = numOne+numTwo;
        int power = (int)Math.log10(sum);
        ListNode res = new ListNode(0);
        ListNode iterate = res;
        if(sum == 0)
            return new ListNode(0);
        while(power>=0){
            int indexNum = (int)(sum/Math.pow(10, power));
            iterate.next = new ListNode(indexNum);
            sum-=Math.pow(10, power)*indexNum;
            iterate = iterate.next;
            power--;
        }

        return res.next;
    }
}
