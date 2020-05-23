package sedgewick.union_find;

public class SuccessorWithDelete {

    int[] array;

    public SuccessorWithDelete(int n) {
        this.array = new int[n];
        for(int i=0;i<n-1;i++){
            array[i] = i+1;
        }
        array[n-1] = n-1;
    }

    public void remove(int index){
        array[index-1] = array[index];
        array[index] = index;
    }

    public int findSuccessor(int index){
        return array[index];
    }

    public static void main(String[] args) {
        SuccessorWithDelete successorWithDelete = new SuccessorWithDelete(10);
        System.out.println("successor of 5: " + successorWithDelete.findSuccessor(5));
        successorWithDelete.remove(7);
        System.out.println("successor of 6: " + successorWithDelete.findSuccessor(6));
    }
}
