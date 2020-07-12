package leetcode.solved.tree;

public class CountCompleteTreeNodes {
    //#222 Count Complete Tree Nodes
    public static void main(String[] args) {
        TreeNodeJava node = new TreeNodeJava(1);
        node.left = new TreeNodeJava(2);
        node.right = new TreeNodeJava(3);
        node.left.left = new TreeNodeJava(4);
        node.left.right = new TreeNodeJava(5);
        node.right.left = new TreeNodeJava(6);

        countNodes(node);
    }

    public static int countNodes(TreeNodeJava root) {
        if(root==null)
            return 0;

        int levels = 0;
        TreeNodeJava iterative = root;
        while(iterative.left!=null){
            levels++;
            iterative = iterative.left;
        }
        int maxElements = (int)Math.pow(2,levels);
        int potentialLoss = maxElements;
        int loss = 0;
        iterative = root;

        while(true) {
            int count = 1;
            if(iterative.right==null){
                loss++;
                break;
            }
            TreeNodeJava currRoot = iterative;

            if (levels > 1) {
                iterative = iterative.right;
                count++;
            }
            while (iterative.left != null) {
                iterative = iterative.left;
                count++;
            }
            if (count < levels) {
                iterative = currRoot.left;
                potentialLoss/=2;
                loss+=potentialLoss;
            } else {
                iterative = currRoot.right;
                potentialLoss/=2;
            }
        }

        return maxElements-loss+1;
    }
}
