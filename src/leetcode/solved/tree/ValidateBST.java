package leetcode.solved.tree;

import java.util.HashSet;
import java.util.Stack;

public class ValidateBST {
    //#98 Validate Binary Search Tree
    public static void main(String[] args) {
        TreeNodeJava node = new TreeNodeJava(-2147483648);
        //node.left = new TreeNode(1);
        System.out.println(isValidBST(node) + " min:" + Integer.MIN_VALUE);
    }

    public static boolean isValidBST(TreeNodeJava root) {

        if (root == null)
            return true;
        boolean anyLeftNodes = false;
        Stack<TreeNodeJava> stack = new Stack<>();
        HashSet<TreeNodeJava> set = new HashSet<>();
        stack.push(root);
        int prevValue = Integer.MIN_VALUE;

        while (!stack.empty()) {
            TreeNodeJava node = stack.peek();
            if (set.contains(node)) {
                node = stack.pop();

                if(anyLeftNodes && node.val<=prevValue)
                    return false;
                else{
                    anyLeftNodes = true;
                    prevValue = node.val;
                }

                if (node.right != null)
                    stack.push(node.right);
            } else {
                set.add(node);
                if (node.left != null)
                    stack.push(node.left);
                else {
                    if(anyLeftNodes && node.val<=prevValue)
                        return false;
                    else{
                        anyLeftNodes = true;
                        prevValue = node.val;
                    }
                    stack.pop();
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }
            }
        }

        return true;
    }
}
