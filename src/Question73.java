public class Question73 {

    public static void main(String[] args){

    }
    //https://leetcode-cn.com/problems/set-matrix-zeroes/description/
    //思路：先遍历一遍矩阵，找到第一个为0的位置(i,j),则可以将第i行和第j列用于存储需要改变为0的列和行
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
                if(i==x){           //避免干扰记录的数据
                    continue;
                }
                for(int j=0;j<n;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=0;j<n;j++){
            if(matrix[x][j]==0){
                for(int i=0;i<m;i++){
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
