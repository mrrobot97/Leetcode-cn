import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

public class Question542 {

    // https://leetcode-cn.com/problems/01-matrix/description/

    //BFS 以0为起点去更新他周围的1，同时将更新后的节点加入遍历队列
    public int[][] updateMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        Queue<Pair<Integer,Integer>> queue=new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    queue.offer(new Pair<>(i,j));
                }else{
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        int[] dx={-1,0,1,0};
        int[] dy={0,-1,0,1};
        while (!queue.isEmpty()){
            Pair<Integer,Integer> p=queue.poll();
            for (int i = 0; i < 4; i++) {
                int x=p.getKey()+dx[i];
                int y=p.getValue()+dy[i];
                if(x>=0 && x<m && y>=0 && y<n && matrix[x][y]>matrix[p.getKey()][p.getValue()]){
                    matrix[x][y]=matrix[p.getKey()][p.getValue()]+1;
                    queue.offer(new Pair<>(x,y));
                }
            }
        }
        return matrix;
    }
}
