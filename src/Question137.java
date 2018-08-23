public class Question137 {
    public static void main(String[] args){

        int[] nums=new int[]{0,1,0,1,0,1,99};

        System.out.println(singleNumber(nums));
    }

    //https://leetcode-cn.com/problems/single-number-ii/description/
    //hint: 遍历数组32次，每次统计数组中各个数字的第i位之和，如果统计后的数字不能整除3，则说明只有一个的数字的第i位位1.
    public static int singleNumber(int[] nums) {
        int a=0;
        int n=nums.length;
        for (int i = 0; i < 32; i++) {
            int cnt=0;
            for (int j=0;j<n;j++){
                cnt+=(nums[j]>>i)&1;
            }
            if(cnt%3!=0){
                a+=(1<<i);
            }
        }
        return a;
    }
}
