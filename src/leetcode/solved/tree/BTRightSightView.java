package leetcode.solved.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTRightSightView {
    //#199 Binary Tree Right Sight View
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new LinkedList<>();
        if(root==null)
            return res;
        Queue<TreeNode> collection = new LinkedList<>();
        collection.add(root);

        int amount = 1;
        while(!collection.isEmpty()){
            int nextLevelAmount = 0;
            res.add(collection.peek().val);
            for(int i=0;i<amount;i++){
                TreeNode node = collection.poll();
                if(node.right!=null){
                    nextLevelAmount++;
                    collection.add(node.right);
                }
                if(node.left!=null){
                    nextLevelAmount++;
                    collection.add(node.left);
                }
            }
            amount = nextLevelAmount;
        }

        return res;
    }
}
