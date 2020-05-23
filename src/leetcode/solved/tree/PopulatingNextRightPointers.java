package leetcode.solved.tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class PopulatingNextRightPointers {
    //#116 Populating Next Right Pointers in Each Node

    public Node connect(Node root) {
        if(root==null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int layerElements = 1;
        while(!queue.isEmpty()){
            for(int i=0;i<layerElements;i++){
                Node node = queue.poll();
                if(i!=layerElements-1)
                    node.next=queue.peek();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            layerElements*=2;
        }
        return root;
    }
}
