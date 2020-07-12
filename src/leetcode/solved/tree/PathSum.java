package leetcode.solved.tree;

public class PathSum {
    //#112 Path Sum
    public static void main(String[] args) {
        TreeNodeJava tree = new TreeNodeJava(-2);
        tree.right = new TreeNodeJava(-3);

        System.out.println("res: " + hasPathSum(tree, -5));
    }

    public static boolean hasPathSum(TreeNodeJava root, int sum) {
        if(root==null)
            return sum == 0;

        sum -= root.val;
        if (root.left == null && root.right == null)
            return sum == 0;
        else {
            boolean one = root.left != null && hasPathSum(root.left, sum);
            boolean two = root.right != null && hasPathSum(root.right, sum);
            return (one || two);
        }
    }

}
