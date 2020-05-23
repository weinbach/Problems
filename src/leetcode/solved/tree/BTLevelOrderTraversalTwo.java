package leetcode.solved.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversalTwo {
    //#107 Binary Tree Level Order Traversal II
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        levelOrderBottom(node);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root==null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int lvlElements = 1;
        while(!queue.isEmpty()){
            int nextLvlElements = 0;
            List<Integer> list = new LinkedList<>();
            for(int i=0;i<lvlElements;i++){
                TreeNode node = queue.poll();
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
