import java.util.HashMap;
import java.util.Map;

public class Question377 {



    public static void main(String[] args){
        int[] nums={1,2,3};
        System.out.print(combinationSum4(nums,4));
    }

    //https://leetcode-cn.com/problems/combination-sum-iv/description/
    //直接dfs很简单，但是会超时,因此用一个HashMap来进行缓存优化

    private static Map<Integer,Integer> cacheMap=new HashMap<>();

    public static int combinationSum4(int[] nums, int target) {
        if(target==0 || nums.length==0){
            return 0;
        }
        cacheMap.clear();
        int cnt=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            cnt+=dfs(nums,target-nums[i]);
        }
        return cnt;
    }


    public static int dfs(int[] nums,int target){
        if(target<0){
            return 0;
        }
        if(target==0){
            return 1;
        }
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(cacheMap.containsKey(target-nums[i])){
                cnt+=cacheMap.get(target-nums[i]);
            }else{
                cnt+=dfs(nums,target-nums[i]);
            }
        }
        cacheMap.put(target,cnt);
        return cnt;
    }
}
