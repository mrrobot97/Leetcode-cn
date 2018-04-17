import java.util.Arrays;

public class Question300 {

    public static void main(String[] args) {

    }

    //最长上升子序列
    public static int lengthOfLIS(int[] nums) {
        int len=nums.length;
        if(len==0){
            return 0;
        }
        int[] dp=new int[len];  //dp[i]表示以i结尾最长子序列的长度
        Arrays.fill(dp,1);  //dp[i]至少为1
        int max=1;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
}
