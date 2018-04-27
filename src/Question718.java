import java.util.Arrays;

public class Question718 {

    // https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/description/
    //dp即可
    public int findLength(int[] A, int[] B) {
        int na=A.length;
        int nb=B.length;
        int[][] d=new int[na][nb];
        for (int i = 0; i < nb; i++) {
            if(A[0]==B[i]){
                d[0][i]=1;
            }
        }
        for (int i = 0; i < na; i++) {
            if(A[i]==B[0]){
                d[i][0]=1;
            }
        }
        for (int i = 1; i < na; i++) {
            for (int j = 1; j < nb; j++) {
                if(A[i]==B[j]){
                    d[i][j]=d[i-1][j-1]+1;
                }else{
                    d[i][j]=0;
                }
            }
        }
        int max=0;
        for (int i = 0; i < na; i++) {
            for (int j = 0; j < nb; j++) {
                max=Math.max(max,d[i][j]);
            }
        }
        return max;
    }
}
