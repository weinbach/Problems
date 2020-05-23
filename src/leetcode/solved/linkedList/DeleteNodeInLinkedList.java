package leetcode.solved.linkedList;

public class DeleteNodeInLinkedList {
    //#237 Delete Node in a Linked List
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
