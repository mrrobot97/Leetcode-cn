public class Question392 {

    public static void main(String[] args){

        String s="abc";
        String t="ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    //https://leetcode-cn.com/problems/is-subsequence/description/
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
