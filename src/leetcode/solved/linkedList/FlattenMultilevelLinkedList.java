package leetcode.solved.linkedList;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node random;
    Node(int val){
        this.val = val;
    }
}

public class FlattenMultilevelLinkedList {
    //#430 Flatten a Multilevel Doubly Linked List

    public static void main(String[] args) {
        Node n1 = new Node(1);

        Node n2 = new Node(2);
        n1.next = n2;
        n2.prev = n1;

        Node n3 = new Node(3);
        n2.next = n3;
        n3.prev = n2;

        Node n4 = new Node(4);
        n3.next = n4;
        n4.prev = n3;

        Node n5 = new Node(5);
        n4.next = n5;
        n5.prev = n4;

        Node n6 = new Node(6);
        n5.next = n6;
        n6.prev = n5;

        Node n7 = new Node(7);
        n3.child = n7;

        Node n8 = new Node(8);
        n7.next = n8;
        n8.prev = n7;

        Node n9 = new Node(9);
        n8.next = n9;
        n9.prev = n8;

        Node n10 = new Node(10);
        n9.next = n10;
        n10.prev = n9;

        Node n11 = new Node(11);
        n8.child = n11;

        Node n12 = new Node(12);
        n11.next = n12;
        n12.prev = n11;

        Node res = flatten(n1);


    }

    public static Node flatten(Node head) {
        Node iterative = head;
        while(iterative!=null){
            if(iterative.child!=null){
                Node nextElement = iterative.next;
                Node childFlatten = flatten(iterative.child);

                iterative.next = childFlatten;
                childFlatten.prev = iterative;
                iterative.child = null;
                iterative = iterative.next;
                while(true){
                    if(iterative.next!=null)
                        iterative=iterative.next;
                    else
                        break;
                }

                iterative.next = nextElement;
                if(nextElement!=null)
                    nextElement.prev = iterative;
                iterative = nextElement;
            } else {
                iterative=iterative.next;
            }
        }

        return head;
    }
}
