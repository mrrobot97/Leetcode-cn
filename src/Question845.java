public class Question845 {

    public static void main(String[] args){
        int[] a=new int[]{2,1,4,7,3,2,5};
        System.out.print(longestMountain(a));
    }

    //hint: 很简单的一个题，不多说了
    //https://leetcode-cn.com/problems/longest-mountain-in-array/description/
    public static int longestMountain(int[] A) {
        int n =A.length;
        if(n<3){
            return 0;
        }
        int[] left=new int[n];
        int[] right=new int[n];
        for(int i=1;i<n;i++){
            if(A[i-1]<A[i]){
                left[i]=left[i-1]+1;
            }else{
                left[i]=0;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(A[i+1]<A[i]){
                right[i]=right[i+1]+1;
            }else{
                right[i]=0;
            }
        }
        int max=0;
        for (int i = 0; i < n; i++) {
            if(left[i]>0 && right[i]>0 && left[i]+right[i]+1>max){
                max=left[i]+right[i]+1;
            }
        }
        return max;
    }
}
