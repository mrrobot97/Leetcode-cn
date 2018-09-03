import javafx.util.Pair;

import java.util.*;

public class Question754 {


    public static void main(String[] args){
        System.out.println(reachNumber(9997));
    }

    //https://leetcode-cn.com/problems/reach-a-number/description/

    // 理解这题的意思 这题就好做了
    // 分析 首先考虑一种比较极端的情况 即一直向正方向移动n步 ，刚好达到target
    // 那么target的值就等于前n步的和 ，也就是1+2+.....+n = n*(n+1)/2
    // 如果n(n+1)/2>target ,那么所需要的步数肯定要比n多，而且肯定有向左走的步子，也就是求和的时候肯定是有负数的，至于哪个或者哪些个为负，下面开始讨论
    //1，n(n+1)/2 - target 为偶数时，所以要想到达 target 需要向左走 n(n+1)/2 - target 偶数步 ，
    // 就是把前n项中第( n(n+1)/2 - target)/2 步变为负号就行了
    //2,当n(n+1)/2 - target 为奇数时，就要分类讨论了，若n为奇数n+1就是偶数 无论向左还是向右 都不会产生一个奇数的差来因此需要再走一步故要n+2步
    //若n为偶数，n+1则为奇数，可以产生一个奇数的差，故要n+1步

    //综上，这是一道数学题
    public static int reachNumber(int target) {
        if(target<0){
            target=-target;
        }
        int sum=0;
        int step=0;
        while (sum<target || (sum-target)%2!=0){    //1+2+3+4+....+n=sum,当(sum-target)%2==0时，
            step++;                                 // 可以通过将左边的一个"+"变为"-"来使得sum=target
            sum+=step;                              //也就是(sum-target)/2前面的"+"变为"-"
        }

        return step;
    }



}
