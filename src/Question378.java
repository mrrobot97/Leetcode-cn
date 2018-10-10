import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;

public class Question378 {

    public static void main(String[] args){
        int[][] matrix={
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };
        System.out.println(kthSmallest(matrix,8));

    }

    //https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
    //hint:求第k小，应当首先想到堆排序(最小堆)
    //1.现将第一行入堆
    //2.重复这个操作k-1次：每次取出堆定，然后将此元素所在同列的下一个元素入堆
    //3.最后堆定即是第k小元素
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Wrapper> queue=new PriorityQueue<>();
        int n=matrix[0].length;
        for (int i = 0; i < n; i++) {
            queue.offer(new Wrapper(0,i,matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Wrapper wrapper=queue.poll();
            if(wrapper.x==matrix.length-1) continue;
            queue.offer(new Wrapper(wrapper.x+1,wrapper.y,matrix[wrapper.x+1][wrapper.y]));
        }
        return queue.poll().val;
    }

    public static class Wrapper implements Comparable<Wrapper>{
        int x;
        int y;
        int val;

        public Wrapper(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }


        @Override
        public int compareTo(@NotNull Wrapper o) {
            return val-o.val;
        }
    }
}
