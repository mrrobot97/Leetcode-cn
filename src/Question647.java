public class Question647 {

    public static void main(String[] args){
        String str="aaaaa";
        System.out.println(countSubstrings(str));
    }

    //https://leetcode-cn.com/problems/palindromic-substrings/description/
    //判断s[i][j]是否为回文只需判断s[i+1][j-1]是否为回文并且s[i]==s[j]，这样可以将时间优化到O(n2)
    public static int countSubstrings(String s) {
        if(s==null || s.length()<=0){
            return 0;
        }
        int n=s.length();
        int cnt=0;
        boolean[][] flags=new boolean[n][n];
        for (int i = 0; i < n; i++) {
            flags[i][i]=true;
            cnt++;
        }
        for (int i = 0; i < n - 1; i++) {
            if(s.charAt(i)==s.charAt(i+1)){
                flags[i][i+1]=true;
                cnt++;
            }
        }
        for(int len=3;len<=n;len++){
            for (int i = 0; i+len-1<n; i++) {
                int j=i+len-1;
                if(flags[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    flags[i][j]=true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
