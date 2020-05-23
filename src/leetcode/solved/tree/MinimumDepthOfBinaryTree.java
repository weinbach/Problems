package leetcode.solved.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    //#111 Minimum Depth of Binary Tree
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);

        TreeNode l1_1 = new TreeNode(2);
        tree.left = l1_1;
        TreeNode l1_2 = new TreeNode(2);
        tree.right = l1_2;

        l1_1.right =  new TreeNode(2);
        l1_1.left =  new TreeNode(2);

        l1_2.right = new TreeNode(2);

        System.out.println("res: " + minDepth(tree));
    }

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int layerSpace = 1;
        int minDepth = 0;

        while (!queue.isEmpty()) {
            int nextLayerNodes = 0;
            minDepth++;

            for (int i = 0; i < layerSpace; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (node.left == null && node.right == null)
                        return minDepth;
                    if (node.left != null) {
                        queue.add(node.left);
                        nextLayerNodes++;
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        nextLayerNodes++;
                    }
                }
            }
            layerSpace = nextLayerNodes;
        }
        return minDepth;
    }
}
