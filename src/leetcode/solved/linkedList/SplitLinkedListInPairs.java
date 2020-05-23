package leetcode.solved.linkedList;

public class SplitLinkedListInPairs {
    //#725 Split Linked List in Pairs

    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ListNode lnCopy = ln;
        for (int i = 2; i <= 2; i++) {
            lnCopy.next = new ListNode(i);
            lnCopy = lnCopy.next;
        }

        ListNode[] res = splitListToParts(ln, 1);

    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int count = 0;

        ListNode iterative = root;
        while(iterative!=null){
            iterative=iterative.next;
            count++;
        }
        int rest = count>k? count%k : 0;
        int partSize = count>k? count/k:1;
        iterative = root;

        for(int i=0;i<k;i++){
            if(iterative==null){
                res[i]=null;
                continue;
            }

            if(rest>0){
                iterative=iterative.next;
                rest--;
            }

            for(int j=0;j<partSize-1;j++){
                iterative=iterative.next;
            }

            ListNode temp = iterative.next;
            iterative.next = null;
            res[i] = root;
            root=temp;
            iterative = root;
        }

        return res;
    }
}
