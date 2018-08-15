import java.util.*;

public class Question814 {


    //https://leetcode-cn.com/problems/binary-tree-pruning/description/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //利用递归，如果子树sum 为0，则砍去子树,这样就避免了回溯,不会超时，因为整个树只遍历了一遍
    public TreeNode pruneTree(TreeNode root) {
        int sum=subTreeSum(root);
        if(sum==0){
            root=null;
        }
        return root;
    }

    public int subTreeSum(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftSum=subTreeSum(node.left);
        int rightSum=subTreeSum(node.right);
        if(leftSum==0){
            node.left=null;
        }
        if(rightSum==0){
            node.right=null;
        }
        return leftSum+rightSum+node.val;
    }
}
