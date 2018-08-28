import javafx.util.Pair;

import java.util.*;

public class Question886 {

    // https://leetcode-cn.com/problems/possible-bipartition/description/
    public static void main(String[] args){

    }

    //使用染色法判断二分图  可使用BFS或者DFS
    //二分图定义:https://zh.wikipedia.org/wiki/二分图
    public static boolean possibleBipartition(int N, int[][] dislikes) {
        int n=dislikes.length;
        if(n==0){
            return true;
        }
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int[] row:dislikes){
            List<Integer> list = map.computeIfAbsent(row[0], k -> new ArrayList<>());
            list.add(row[1]);
            list = map.computeIfAbsent(row[1], k -> new ArrayList<>());
            list.add(row[0]);
        }

        Queue<Integer> queue=new ArrayDeque<>();
        int[] color=new int[N+1];
        for(int i=1;i<=N;i++){
            if(color[i]!=0){
                continue;
            }
            color[i]=1;
            queue.add(i);
            while (!queue.isEmpty()){
                int a=queue.poll();
                List<Integer> list=map.get(a);
                if(list==null) continue;
                for(int b:list){
                    if(color[b]==color[a]) return false;    //相邻顶点但是颜色一样，说明不是二分图
                    if(color[b]==0){                        //给相邻顶点染上不同颜色
                        color[b]=0-color[a];
                        queue.add(b);
                    }
                }
            }
        }
        return true;
    }
}
