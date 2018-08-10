import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question397 {

    public static void main(String[] args){

        System.out.print(integerReplacement(10000));
    }

    //https://leetcode-cn.com/problems/integer-replacement/description/
    //hint: 用递归非常简单，但是当n很大时会stackOverFlow...
    public static int integerReplacement(int n) {
        if(n==Integer.MAX_VALUE){
            return 32;
        }
        int step=0;
        while (n!=1){
            if(n%2==0){
                n/=2;
            }else{
               if((n+1)%4==0 && n!=3){      //n+1能整除4则n-1一定不能整除4,选择能整除4能更快减小n的值,  n==3时是特殊情况
                   n+=1;
               }else{
                   n-=1;
               }
            }
            step++;
        }
        return step;
    }
}
