import java.util.Arrays;

public class Question462 {


    public static void main(String[] args){
        int[] a=new int[]{1,3,2};
        System.out.println(minMoves2(a));
    }

    //https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii/description/
    //hint:排序后寻找最中间的数x，对于a,b，若有a<x && b>x ,则|a-x|+|b-x|=b-a为固定值，因此位于x两边的数可以两两消除，因为他们变为x
    //的步数之和为固定值b-a，对于c=x，则无需变动,因此寻找排序后最中间的数即可。
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int diff=0;
        int mid=nums[n/2];
        for (int i = 0; i < n; i++) {
            diff+=Math.abs(nums[i]-mid);
        }
        return diff;
    }
}
