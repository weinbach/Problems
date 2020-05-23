package leetcode.solved.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SameTree {
    //#100 Same Tree

    public static void main(String[] args) {
        TreeNode asd = null;
        TreeNode ww = new TreeNode(2);
        System.out.println(asd == ww);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                if (isSameTree(p.left, q.left))
                    return isSameTree(p.right, q.right);
                else return false;
            } else
                return false;
        } else return p == q;
    }
}
