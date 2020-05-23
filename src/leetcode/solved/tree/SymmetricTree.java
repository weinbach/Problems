package leetcode.solved.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    //# 101 Symmetric Tree

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1_1 = new TreeNode(4);
        TreeNode l1_2 = new TreeNode(4);
        root.left = l1_1;
        root.right = l1_2;

        TreeNode l2_1 = new TreeNode(5);
        TreeNode l2_4 = new TreeNode(5);

        l1_1.left = l2_1;
        l1_2.right = l2_4;

        l2_1.left = new TreeNode(6);
        l2_4.right = new TreeNode(6);

        System.out.println("res:" + isSymmetricTwo(root));
    }

    //Non efficient. self solve
    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int size = 1;
        while (!queue.isEmpty()) {
            Integer[] elements = new Integer[size];
            boolean isEmptyLevel = true;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    isEmptyLevel = false;
                    queue.add(node.left);
                    queue.add(node.right);
                    elements[i] = node.val;
                } else {
                    queue.add(null);
                    queue.add(null);
                    elements[i] = null;
                }
            }

            size *= 2;
            if (isEmptyLevel)
                break;

            int indexStart = 0;
            int indexEnd = elements.length - 1;
            while (indexEnd > indexStart) {
                if (elements[indexStart] != elements[indexEnd])
                    return false;
                indexEnd--;
                indexStart++;
            }
        }

        return true;
    }

    // read an answer
    public static boolean isSymmetricTwo(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode nodeOne = queue.poll();
            TreeNode nodeTwo = queue.poll();

            if (nodeOne == null && nodeTwo == null)
                continue;
            else if (nodeOne==null || nodeTwo==null)
                return false;
            else if(nodeOne.val!=nodeTwo.val)
                return false;

            queue.add(nodeOne.left);
            queue.add(nodeTwo.right);
            queue.add(nodeOne.right);
            queue.add(nodeTwo.left);
        }

        return true;
    }
}
