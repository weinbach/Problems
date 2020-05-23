package leetcode.solved.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersTwo {
    //#117 Populating Next Right Pointers in Each Node II

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        if(root==null)
            return null;

        int elements = 1;
        while (!queue.isEmpty()){
            int tempCounter = 0;
            for(int i=0;i<elements;i++){
                Node node = queue.poll();
                if(i!=elements-1)
                    node.next = queue.peek();
                if(node.left!=null){
                    tempCounter++;
                    queue.add(node.left);
                }
                if(node.right!=null){
                    tempCounter++;
                    queue.add(node.right);
                }
            }
            elements = tempCounter;
        }
        return root;
    }
}
