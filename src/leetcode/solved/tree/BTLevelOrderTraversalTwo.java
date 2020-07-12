package leetcode.solved.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversalTwo {
    //#107 Binary Tree Level Order Traversal II
    public static void main(String[] args) {
        TreeNodeJava node = new TreeNodeJava(3);
        node.left = new TreeNodeJava(9);
        node.right = new TreeNodeJava(20);
        node.right.left = new TreeNodeJava(15);
        node.right.right = new TreeNodeJava(7);

        levelOrderBottom(node);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNodeJava root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root==null)
            return res;
        Queue<TreeNodeJava> queue = new LinkedList<>();
        queue.add(root);

        int lvlElements = 1;
        while(!queue.isEmpty()){
            int nextLvlElements = 0;
            List<Integer> list = new LinkedList<>();
            for(int i=0;i<lvlElements;i++){
                TreeNodeJava node = queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                    nextLvlElements++;
                }
                if(node.right!=null){
                    queue.add(node.right);
                    nextLvlElements++;
                }
            }
            lvlElements = nextLvlElements;
            res.addFirst(list);
        }

        return res;
    }
}
