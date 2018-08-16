import java.util.*;

public class Question384 {

    public static void main(String[] args){
        int[] nums=new int[]{1,2,3};
        Solution solution=new Solution(nums);
        for (int i = 0; i < 100; i++) {
            System.out.println(Arrays.toString(solution.shuffle()));
        }
    }

    //https://leetcode-cn.com/problems/shuffle-an-array/description/
    static class Solution{
        int[] nums;
        public Solution(int[] nums) {
            this.nums=nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            //simple version
//            int n=nums.length;
//            List<Integer> list= new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                list.add(nums[i]);
//            }
//            Collections.shuffle(list);
//            int[] arr=new int[n];
//            for (int i = 0; i < n; i++) {
//                arr[i]=list.get(i);
//            }
//            return arr;

            //another version
            int[] arr=nums.clone();
            Random random=new Random();
            for(int i=arr.length-1;i>0;i--){
                int j= random.nextInt(i+1);
                if(i!=j){
                    int tp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tp;
                }
            }
            return arr;
        }
    }

}
