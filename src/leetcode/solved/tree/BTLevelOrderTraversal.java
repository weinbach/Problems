package leetcode.solved.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
    //#102 Binary Tree Level Order Traversal
    public static void main(String[] args) {
        TreeNodeJava root = new TreeNodeJava(3);
        TreeNodeJava l1_1 = new TreeNodeJava(4);
        TreeNodeJava l1_2 = new TreeNodeJava(4);
        root.left = l1_1;
        root.right = l1_2;

        TreeNodeJava l2_1 = new TreeNodeJava(5);
        TreeNodeJava l2_4 = new TreeNodeJava(5);

        l1_1.left = l2_1;
        l1_2.right = l2_4;

        l2_1.left = new TreeNodeJava(6);
        l2_4.right = new TreeNodeJava(6);

        System.out.println("res:" + levelOrder(null));
    }
    public static List<List<Integer>> levelOrder(TreeNodeJava root) {
        Queue<TreeNodeJava> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root!=null)
            queue.add(root);

        int layerElement = 1;
        while(!queue.isEmpty()){
            int nextLevelElements = 0;
            List<Integer> list = new LinkedList<>();
            for(int i=0;i<layerElement;i++){
                TreeNodeJava node = queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                    nextLevelElements++;
                }
                if(node.right!=null){
                    queue.add(node.right);
                    nextLevelElements++;
                }
            }
            layerElement = nextLevelElements;
            res.add(list);
        }
        return res;
    }
}
