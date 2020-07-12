package leetcode.solved.tree;

import java.util.LinkedList;
import java.util.Queue;

//#1379 Find a Corresponding Node of a Binary Tree in a Clone of That Tree
public class FindNodeInClonedBt {

    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        Queue<TreeNode> queue = new LinkedList<>();
        if (original != null)
            queue.add(original);
        else
            return null;

        int levels = 1, currLvlNodes = 1;
        int currNodeIndex = 0, nextLvlNodes = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currNodeIndex++;

            if(node.equals(target)){
                break;
            }
            if (node.left != null) {
                queue.add(node.left);
                nextLvlNodes++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLvlNodes++;
            }

            if(currNodeIndex == currLvlNodes){
                if(nextLvlNodes>0)
                    levels++;
                currLvlNodes = nextLvlNodes;
                nextLvlNodes = 0;
                currNodeIndex = 0;
            }

        }
        queue.clear();
        queue.add(cloned);

        int currLvl = 1, currLvl_nodes = 1;
        int currNode_index = 0, nextLvl_nodes = 0;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            currNode_index++;

            if(currNode_index==currNodeIndex && currLvl == levels){
                return node;
            }

            if(node.left!=null){
                queue.add(node.left);
                nextLvl_nodes++;
            }
            if(node.right!=null){
                queue.add(node.right);
                nextLvl_nodes++;
            }
            if(currNode_index==currLvl_nodes){
                currLvl++;
                currLvl_nodes=nextLvl_nodes;
                nextLvl_nodes = 0;
                currNode_index = 0;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(4);
        TreeNode target = new TreeNode(3);
        node.right = target;
        target.left = new TreeNode(6);
        target.right = new TreeNode(19);

        TreeNode node2 = new TreeNode(7);
        node2.left = new TreeNode(4);
        node2.right = new TreeNode(3);
        node2.right.left = new TreeNode(6);
        node2.right.right = new TreeNode(19);

        System.out.printf("asd" + getTargetCopy(node, node2, target).val);

    }

}
