package leetcode.solved.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    //#104 Maximum Depths of Binary Tree
    public static void main(String[] args) {
        TreeNodeJava tree = new TreeNodeJava(1);
        tree.right = new TreeNodeJava(2);
        System.out.println("res: " + maxDepth(tree));
    }

    public static int maxDepth(TreeNodeJava root) {
        if(root==null)
            return 0;
        Queue<TreeNodeJava> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        int layerSpace = 1;

        while(!queue.isEmpty()){
            int nextLayerSpace = 0;
            depth++;

            for(int i=0;i<layerSpace;i++){
                TreeNodeJava node = queue.poll();
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
