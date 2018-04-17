
import javafx.util.Pair;

import java.util.*;

public class Question130 {
    public static void main(String[] args){

    }

    //思路：从所有在边界上的‘O’开始遍历，每次遍历前后左右相邻的'0'并标记为已读，最后所有没有被访问过的'0'即是被包围的'0'
    public static void solve(char[][] board) {
        int x=board.length;
        if(x==0){
            return;
        }
        int y=board[0].length;
        int[][] visit=new int[x][y];
        int[] dx=new int[]{-1,0,1};
        int[] dy=new int[]{-1,0,1};
        Queue<Pair<Integer,Integer>> queue=new ArrayDeque<>();
        for(int j=0;j<y;j++){
            if(board[0][j]=='O'){
                queue.offer(new Pair<>(0,j));
                visit[0][j]=1;
            }
            if(board[x-1][j]=='O'){
                queue.offer(new Pair<>(x-1,j));
                visit[x-1][j]=1;
            }
        }
        for(int i=0;i<x;i++){
            if(board[i][0]=='O'){
                queue.offer(new Pair<>(i,0));
                visit[i][0]=1;
            }
            if(board[i][y-1]=='O'){
                queue.offer(new Pair<>(i,y-1));
                visit[i][y-1]=1;
            }
        }
        while (!queue.isEmpty()){
            Pair<Integer,Integer> pair=queue.poll();
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(dx[i]*dy[j]!=0){
                        continue;
                    }
                    if(dx[i]==0 && dy[j]==0){
                        continue;
                    }
                    int xx=pair.getKey()+dx[i];
                    int yy=pair.getValue()+dy[j];
                    if(xx<0 || xx>=x || yy<0 || yy>=y){
                        continue;
                    }
                    if(board[xx][yy]=='O' && visit[xx][yy]==0){
                        visit[xx][yy]=1;
                        queue.offer(new Pair<>(xx,yy));
                    }
                }
            }
        }
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(board[i][j]=='O' && visit[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }

}
