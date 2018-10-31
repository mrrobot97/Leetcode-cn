import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Question515 {


    public static void main(String[] args){

    }

     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    //hint: 找到如何确定什么时候是新起一行即可
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        int max=root.val;
        if(root.left!=null){
            queue.add(root.left);
        }
        if(root.right!=null){
            queue.add(root.right);
        }
        TreeNode parent=root;
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if( (parent!=null && parent.left==node) || ( parent!=null && parent.right==node)){        //a new line
                list.add(max);
                max=node.val;
                parent=null;
            }else if(node.val>max){
                max=node.val;
            }
            if(node.left!=null){
                queue.add(node.left);
                if(parent==null){
                    parent=node;
                }
            }
            if(node.right!=null){
                queue.add(node.right);
                if(parent==null){
                    parent=node;
                }
            }
        }
        list.add(max);
        return list;
    }
}
