import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Question863 {

    public static void main(String[] args){

    }

    //https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/description/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //hint: 先从root开始bfs遍历将树变成图，然后从target开始bsf即可
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> list=new ArrayList<>();
        if(K==0){
            list.add(target.val);
            return list;
        }
        TreeNode[][] map=new TreeNode[501][3];
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        if(root.left!=null){
            map[root.val][0]=root.left;
        }
        if(root.right!=null){
            map[root.val][1]=root.right;
        }
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.left!=null){
                map[cur.left.val][0]=cur;
                if(cur.left.left!=null){
                    map[cur.left.val][1]=cur.left.left;
                }
                if(cur.left.right!=null){
                    map[cur.left.val][2]=cur.left.right;
                }
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                map[cur.right.val][0]=cur;
                if(cur.right.left!=null){
                    map[cur.right.val][1]=cur.right.left;
                }
                if(cur.right.right!=null){
                    map[cur.right.val][2]=cur.right.right;
                }
                queue.offer(cur.right);
            }
        }
        int[] step=new int[501];
        boolean[] visit=new boolean[501];
        step[target.val]=0;
        visit[target.val]=true;
        queue.offer(target);
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            for (int i = 0; i < 3; i++) {
                if(map[cur.val][i]!=null && !visit[map[cur.val][i].val]){
                    step[map[cur.val][i].val]=step[cur.val]+1;
                    visit[map[cur.val][i].val]=true;
                    if(step[map[cur.val][i].val]<K){
                        queue.offer(map[cur.val][i]);
                    }else{
                        list.add(map[cur.val][i].val);
                    }
                }
            }
        }
        return list;
    }
}
