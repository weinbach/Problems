package leetcode.solved.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BTZigzagLevelOrderTraversal {
    //#103 Binary Tree Zigzag Level Order Traversal
    public static void main(String[] args) {
        TreeNode node = new TreeNode(12);
        node.left = new TreeNode(10);
        node.right = new TreeNode(16);
        node.left.left = new TreeNode(8);
        node.left.right = new TreeNode(11);

        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(20);

        zigzagLevelOrder(node);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean direct = true;

        int lvlElements = 1;
        while (!queue.isEmpty()) {
            int nextLvlElements = 0;
            List<Integer> list = new LinkedList<>();
            Deque<TreeNode> temp = new LinkedList<>();
            for (int i = 0; i < lvlElements; i++) {
                TreeNode node = queue.removeLast();
                list.add(node.val);
                if (direct) {
                    if (node.left != null) {
                        temp.add(node.left);
                        nextLvlElements++;
                    }
                    if (node.right != null) {
                        temp.add(node.right);
                        nextLvlElements++;
                    }
                } else {
                    if (node.right != null) {
                        temp.add(node.right);
                        nextLvlElements++;
                    }
                    if (node.left != null) {
                        temp.add(node.left);
                        nextLvlElements++;
                    }
                }
            }
            queue = temp;
            direct = !direct;
            lvlElements = nextLvlElements;
            res.add(list);
        }

        return res;
    }
}
