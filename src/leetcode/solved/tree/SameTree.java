package leetcode.solved.tree;

class TreeNodeJava {
    int val;
    TreeNodeJava left;
    TreeNodeJava right;

    TreeNodeJava(int x) {
        val = x;
    }
}

public class SameTree {
    //#100 Same Tree

    public static void main(String[] args) {
        TreeNodeJava asd = null;
        TreeNodeJava ww = new TreeNodeJava(2);
        System.out.println(asd == ww);
    }

    public boolean isSameTree(TreeNodeJava p, TreeNodeJava q) {
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
