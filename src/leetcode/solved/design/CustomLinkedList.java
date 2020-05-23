package leetcode.solved.design;

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class CustomLinkedList {
    //#707 Design Linked List
    public static void main(String[] args) {
        CustomLinkedList ll = new CustomLinkedList();
        ll.addAtHead(4);
        ll.get(1);
        ll.addAtHead(1);
        ll.addAtHead(5);
        ll.deleteAtIndex(3);
        ll.addAtHead(7);
        ll.get(3);
        ll.get(3);
        ll.get(3);
        ll.addAtHead(1);
        ll.deleteAtIndex(4);

        ll.showAll();

       //"addAtHead","get","addAtHead","addAtHead","deleteAtIndex","addAtHead","get","get","get","addAtHead","deleteAtIndex"]
       //[4],[1],[1],[5],[3],[7],[3],[3],[3],[1],[4]]
    }

    Node node;

    public int get(int index) {
        Node tempNode = node;
        while (index > 0) {
            if (tempNode.next == null)
                return -1;
            index--;
            tempNode = tempNode.next;
        }
        return tempNode.data;
    }

    public void addAtHead(int data) {
        Node n = new Node(data);
        if (node != null) {
            n.next = node;
        }
        this.node = n;
    }

    public void addAtTail(int data) {
        Node tempCurr = node;
        Node n = new Node(data);
        if (node == null) {
            this.node = n;
        } else {
            while (tempCurr.next != null) {
                tempCurr = tempCurr.next;
            }
            tempCurr.next = n;
        }
    }

    public void addAtIndex(int index, int data) {
        if(index == 0){
            addAtHead(data);
            return;
        }
        Node tempNode = node;
        while (index > 1) {
            if (tempNode.next == null)
                return;
            tempNode = tempNode.next;
            index--;
        }
        Node addingNode = new Node(data);
        addingNode.next = tempNode.next;
        tempNode.next = addingNode;
    }

    public void deleteAtIndex(int index) {
        if(node == null)
            return;

        Node tempCurr = node;
        while (index > 1) {
            if (tempCurr.next == null)
                return;
            index--;
            tempCurr = tempCurr.next;
        }
        if(index == 0){
            node = node.next;
            return;
        }
        if(tempCurr.next!=null)
            tempCurr.next = tempCurr.next.next;
    }

    public void showAll() {
        Node temp = node;
        while (temp != null) {
            System.out.print("-> " + temp.data);
            temp = temp.next;
        }
        System.out.println("");
    }

}
