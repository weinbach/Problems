package leetcode.solved.linkedList;

public class RemoveZeroSumConsecutive {
    //#1171 Remove Zero Sum Consecutive Nodes from Linked List

    public ListNode removeZeroSumSublists(ListNode head) {
        if(head==null)
            return null;

        int size = 0;
        ListNode iterative = head;
        while(iterative!=null){
            size++;
            iterative=iterative.next;
        }
        iterative = head;

        int[] array = new int[size];
        int index = 0;
        while(iterative!=null){
            array[index] = iterative.val;
            iterative=iterative.next;
            index++;
        }
        iterative=head;


        int sum;
        for(int i=0;i<array.length;i++){
            sum = array[i];
            for(int j=i+1;j<array.length;j++){
                sum+=array[j];
                if(sum==0){
                    for(int s=i;s<=j;s++)
                        array[s] = 0;
                    i=j;
                    break;
                }
            }
        }

        int resSize = 0;
        boolean first = true;
        boolean anyValue = false;
        for (int value : array) {
            if (value != 0) {
                if (!first)
                    iterative = iterative.next;
                iterative.val = value;
                resSize++;
                first = false;
                anyValue =true;
            }
        }

        if(!anyValue)
            return null;
        if(resSize!=size)
            iterative.next = null;

        return head;
    }
}
