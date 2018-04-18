public class Question73 {

    public static void main(String[] args){

    }
    //https://leetcode-cn.com/problems/set-matrix-zeroes/description/
    //思路：先遍历一遍矩阵，找到第一个为0的位置(i,j),则可以将第i行和第j列用于存储需要改变为0的行和列
    public static void setZeroes(int[][] matrix) {
        int m=matrix.length;
        if(m==0){
            return;
        }
        int n=matrix[0].length;
        if(n==0){
            return;
        }
        boolean find=false;
        int x=0,y=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    x=i;
                    y=j;
                    find=true;
                    break;
                }
            }
            if(find){
                break;
            }
        }
        if(!find){
            return;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[x][j]=0;
                    matrix[i][y]=0;
                }
            }
        }
        for(int i=0;i<m;i++){
            if(matrix[i][y]==0){
                for(int j=0;j<n;j++){
                    if(i==x || j==y){       //先不处理第x行和第y列的
                        continue;
                    }
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=0;j<n;j++){
            if(matrix[x][j]==0){
                for(int i=0;i<m;i++){
                    if(i==x || j==y){
                        continue;
                    }
                    matrix[i][j]=0;
                }
            }
        }
        for(int i=0;i<m;i++){
            matrix[i][y]=0;
        }
        for(int j=0;j<n;j++){
            matrix[x][j]=0;
        }
    }
}
