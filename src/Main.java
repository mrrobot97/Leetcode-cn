import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    }


    public static int lengthOfLongestSubstring(String s) {
        int len=s.length();
        if(len==0){
            return 0;
        }
        int pos[]=new int[256]; //存储s[i]最近出现的位置
        int dp[]=new int[len];
        Arrays.fill(pos,-1);
        dp[0]=1;
        pos[s.charAt(0)]=0;
        int max=1;
        int start=0;             //记录当前最长子串开始的位置
        for(int i=1;i<len;i++){
            int location=pos[s.charAt(i)];
            if(location==-1 || location<start){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=i-location;
                start=location+1;
            }
            pos[s.charAt(i)]=i;
            if(dp[i]>max){
                max=dp[i];
            }
        }

        return max;
    }
}
