public class Question309 {


    public static void main(String[] args){
        int[] prices=new int[]{1,0,2,4};
        System.out.println(maxProfit(prices));
    }

    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
    //dp,难点在于转换公式
    public static int maxProfit(int[] prices) {
        int max=0;
        int n=prices.length;
        if(n<2){
            return 0;
        }
        int[][] dp=new int[n][n];   //dp[i][j]表示第i天买入第j天卖出时当前一共获取的最大利益,
        int maxlk=0;                //dp[i][j]=-prices[i]+prices[j]+max{dp[l][k}(l<k<i-1<i<j)
        for (int i = 0; i < n; i++) {
            for(int l=0;l<i-2;l++){
                maxlk=Math.max(maxlk,dp[l][i-2]);
            }
            for (int j = i+1; j < n; j++) {
                dp[i][j]=-prices[i]+prices[j];
                dp[i][j]+=maxlk;
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
