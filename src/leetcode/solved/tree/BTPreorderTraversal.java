package leetcode.solved.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BTPreorderTraversal {
    //#144 Binary Tree Preorder Traversal

    public static List<Integer> preorderTraversalRec(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null)
            return res;
        res.add(root.val);
        res.addAll(preorderTraversalRec(root.left));
        res.addAll(preorderTraversalRec(root.right));
        return res;
    }

    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
           TreeNode node = stack.pop();
           res.add(node.val);
           if(node.right!=null)
               stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }

        return res;
    }
}
