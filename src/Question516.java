public class Question516 {
    public static void main(String[] args){
        String s="bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }

    //https://leetcode-cn.com/problems/longest-palindromic-subsequence/description/
    //求s和s.reverse的最长公共子序列
    public static int longestPalindromeSubseq(String s) {
        int n=s.length();
        if(n<=0){
            return 0;
        }
        int ans=1;
        String sr=new StringBuilder(s).reverse().toString();
        int[][] dp=new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(s.charAt(i-1)==sr.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
