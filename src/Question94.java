import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
public class Question94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }

        TreeNode node=root;
        Stack<TreeNode> stack=new Stack<>();
        while (node!=null || !stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            list.add(node.val);
            node=node.right;
        }
        return list;
    }

}
