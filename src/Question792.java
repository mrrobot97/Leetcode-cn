public class Question792 {

    //https://leetcode-cn.com/problems/number-of-matching-subsequences/description/
    public int numMatchingSubseq(String S, String[] words) {
        int cnt=0;
        for(String str:words){
            if(isSubsequence(str,S)) cnt++;
        }
        return cnt;
    }

    public static boolean isSubsequence(String s, String t) {
        int n=s.length();
        if(n<=0){
            return true;
        }
        int i=0,j=0;
        boolean flag=false;
        while (i<n&&j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
                if(i==n){
                    flag=true;
                    break;
                }
            }else{
                j++;
            }
        }
        return flag;
    }
}
