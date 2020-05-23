package leetcode.solved.tree;

public class PathSum {
    //#112 Path Sum
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(-2);
        tree.right = new TreeNode(-3);

        System.out.println("res: " + hasPathSum(tree, -5));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
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
