import java.util.ArrayList;
import java.util.List;

public class Question442 {

    public static void main(String[] args){
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }

    //https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/description/
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int n=nums.length;

        for (int i = 0; i < n; i++) {
            int index=Math.abs(nums[i])-1;
            if(nums[index]<0){
                list.add(index+1);
            }
            nums[index]=-nums[index];
        }

        return list;
    }
}
