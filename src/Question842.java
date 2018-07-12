
import java.util.ArrayList;
import java.util.List;

public class Question842 {

    public static void main(String[] args){
        List<Integer> list=splitIntoFibonacci("214748364721474836422147483641");
        System.out.print(list);
    }

    //https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/description/

    //枚举a,b即可，需要注意各种边界条件
    public static List<Integer> splitIntoFibonacci(String s) {
        List<Integer> list=new ArrayList<>();
        int n=s.length();
        if(n<3){
            return list;
        }
        int a,b;
        for(int i=1;i<n-1 && i<11;i++){
            if(s.substring(0,i).startsWith("0") && i>1){
                continue;
            }
            long tp=Long.decode(s.substring(0,i));
            if(tp>Integer.MAX_VALUE){
                continue;
            }
            a=Integer.decode(s.substring(0,i));
            boolean flag=false;
            for(int j=i+1;j<n && j-i<11;j++){
                if(s.substring(i,j).startsWith("0") && j-i>1){
                    continue;
                }
                tp=Long.decode(s.substring(i,j));
                if(tp>Integer.MAX_VALUE){
                    continue;
                }
                b=Integer.decode(s.substring(i,j));
                list.clear();
                list.add(a);
                list.add(b);
                int len=n-j;
                int jj=j;
                while (len>0){
                    int c=list.get(list.size()-1)+list.get(list.size()-2);
                    if(s.substring(jj).startsWith(c+"")){
                        list.add(c);
                        if(c==0){
                            len--;
                            jj++;
                        }else{
                            while (c>0){
                                c/=10;
                                len--;
                                jj++;
                            }
                        }
                        if(len==0){
                            flag=true;
                        }
                    }else{
                        flag=false;
                        break;
                    }
                }
                if(!flag){
                    list.clear();
                    continue;
                }
                break;
            }
            if(flag){
                break;
            }
        }

        return list;
    }
}
