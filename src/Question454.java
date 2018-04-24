import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Question454 {

    public static void main(String[] args){
        int[] a=new int[]{-1,-1};
        int[] b=new int[]{-1,1};
        int[] c=new int[]{-1,1};
        int[] d=new int[]{1,-1};
        System.out.println(fourSumCount(a,b,c,d));


    }
    // https://leetcode-cn.com/problems/4sum-ii/description/
    //O(n^3log(n))超时
    //O(n^2log(n))超时
    //通过利用HashMap O(1)的查找时间复杂度，将最终的时间复杂度降低到O(n^2)
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int cnt=0;
        HashMap<Integer,Integer> cdMap=new HashMap<>();
        for(int c:C){
            for(int d:D){
                int tmp=cdMap.getOrDefault(c+d,0);
                cdMap.put(c+d,tmp+1);
            }
        }
       for(int a:A){
            for(int b:B){
                cnt+=cdMap.getOrDefault(-a-b,0);
            }
       }

        return cnt;
    }
}
