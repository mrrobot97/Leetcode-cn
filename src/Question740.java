import java.util.*;

public class Question740 {

    public static void main(String[] args) {
        int[] nums = new int[]{8, 3, 4, 7, 6, 6, 9, 2, 5, 8, 2, 4, 9, 5, 9, 1, 5, 7, 1, 4};
        System.out.println(deleteAndEarn(nums));
    }

    //https://leetcode-cn.com/problems/delete-and-earn/description/
    //dp
    public static int deleteAndEarn(int[] nums) {
        int[] dp = new int[10001];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer a = map.get(i);
            map.put(i, a == null ? 1 : a + 1);
        }
        dp[1] = map.get(1) == null ? 0 : map.get(1);
        for (int i = 2; i < 10001; i++) {
            int cnt = map.get(i) == null ? 0 : map.get(i);
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * cnt);   //这里不用考虑dp[i-1]+i*cnt这种情况，因为如果dp[i-1]没有取nums[i]
        }                                                       //则必有dp[i-1]=dp[i-2]
        return dp[10000];
    }

}
