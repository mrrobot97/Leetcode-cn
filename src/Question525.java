import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Question525 {
    public static void main(String[] args){
        int[] arr=new int[]{0,1};
        System.out.println(findMaxLength(arr));
    }

    //https://leetcode-cn.com/problems/contiguous-array/description/
    public static int findMaxLength(int[] nums) {
        int n=nums.length;
        if(n<=0) return 0;
        int max=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i]>0?1:-1;
            if(map.containsKey(sum)){
                int j=map.get(sum);
                if(i-j>max) max=i-j;
            }else{
                map.put(sum,i);
            }
        }
        return max;
    }
}
