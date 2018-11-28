import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question39 {

    public static void main(String[] args) {
        int[] a=new int[]{2,3,5};
        combinationSum(a,8);
    }

    //https://leetcode-cn.com/problems/combination-sum/description/
    //dfs的思想
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> testList=new ArrayList<>();
            testList.add(candidates[i]);
            dfs(list,testList,candidates,i,target-candidates[i]);
        }
        for (List<Integer> l:list){
            for(int i:l){
                System.out.print(i+" ");
            }
            System.out.println("");
        }
        return list;
    }


    public static void dfs(List<List<Integer>> list,List<Integer> testList,int[] candidates,int endIndex,int target){
        if(target<0){
            return;
        }else if(target==0){
            list.add(testList);
            return;
        }
        for (int i = 0; i <= endIndex; i++) {
            List<Integer> tmpList=new ArrayList<>(testList);
            tmpList.add(candidates[i]);
            dfs(list,tmpList,candidates,i,target-candidates[i]);        //确保不会有重复的
        }
    }

}
