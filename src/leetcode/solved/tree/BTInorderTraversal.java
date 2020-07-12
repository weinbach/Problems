package leetcode.solved.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BTInorderTraversal {
    //#94 Binary Tree Inorder Traversal

    public static void main(String[] args) {
        TreeNodeJava tree = new TreeNodeJava(1);
        tree.right = new TreeNodeJava(2);
        tree.right.left = new TreeNodeJava(3);

        inorderTraversalIterative2(tree);
    }

    public static List<Integer> inorderTraversalRec(TreeNodeJava root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        res.addAll(inorderTraversalIterative(root.left));
        res.add(root.val);
        res.addAll(inorderTraversalIterative(root.right));
        return res;
    }

    public static List<Integer> inorderTraversalIterative(TreeNodeJava root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        Stack<TreeNodeJava> stack = new Stack<>();
        HashSet<TreeNodeJava> set = new HashSet<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNodeJava node = stack.peek();
            if (set.contains(node)) {
                node = stack.pop();
                res.add(node.val);
                if (node.right != null)
                    stack.push(node.right);
            } else {
                set.add(node);
                if (node.left != null)
                    stack.push(node.left);
                else {
                    res.add(node.val);
                    stack.pop();
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }
            }
        }

        return res;
    }

    public static List<Integer> inorderTraversalIterative2(TreeNodeJava root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNodeJava> stack = new Stack<>();
        TreeNodeJava curr = root;

        do {
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        } while(curr != null ||!stack.empty());
        return res;
    }

}
