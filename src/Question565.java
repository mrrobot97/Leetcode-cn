import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Question565 {

    public static void main(String[] args){

    }

    // https://leetcode-cn.com/problems/array-nesting/description/
    // O(n^2)的会超时
    // 可知由一个环或多个环组成，不会有交叉，求最大环的长度
    public static int arrayNesting(int[] nums) {
        int n=nums.length;
        int maxsize=0;
        for(int i=0;i<n;i++)
        {
            int size=0;
            for(int k=i;nums[k]>=0;size++)
            {
                int numk=nums[k];
                nums[k]=-1;
                k=numk;
            }
            maxsize=Integer.max(maxsize,size);
        }
        return maxsize;
    }
}
