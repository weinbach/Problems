package leetcode.solved.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    //#104 Maximum Depths of Binary Tree
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        System.out.println("res: " + maxDepth(tree));
    }

    public static int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        int layerSpace = 1;

        while(!queue.isEmpty()){
            int nextLayerSpace = 0;
            depth++;

            for(int i=0;i<layerSpace;i++){
                TreeNode node = queue.poll();
                if(node!=null){
                    if(node.left!=null){
                        queue.add(node.left);
                        nextLayerSpace++;
                    }
                    if(node.right!=null){
                        queue.add(node.right);
                        nextLayerSpace++;
                    }
                }
            }

            layerSpace=nextLayerSpace;
        }
        return depth;
    }
}
