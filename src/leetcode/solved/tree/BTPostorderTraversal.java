package leetcode.solved.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BTPostorderTraversal {
    //#145 Binary Tree Postorder Traversal

    public List<Integer> postorderTraversal(TreeNodeJava root) {

        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;

        Stack<TreeNodeJava> stack = new Stack<>();
        HashSet<TreeNodeJava> set = new HashSet<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNodeJava node = stack.peek();

            if (node.left != null && !set.contains(node.left)) {
                stack.add(node.left);
            } else if (node.right != null && !set.contains(node.right)) {
                stack.add(node.right);
            } else if ((node.left == null || set.contains(node.left)) && (node.right == null || set.contains(node.right))) {
                stack.pop();
                set.add(node);
                res.add(node.val);
            }
        }

        return res;
    }

}
